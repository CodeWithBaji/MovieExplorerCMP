package com.moviewexplorer.app.features.listingScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.usecase.GetPopularUseCase
import com.moviewexplorer.app.domain.usecase.GetTopRatedMoviesUseCase
import com.moviewexplorer.app.domain.usecase.GetTrendingUseCase
import com.moviewexplorer.app.domain.usecase.SearchUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class ListingViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularUseCase,
    private val getTrendingUseCase: GetTrendingUseCase,
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ListingState())
    val state = _state.asStateFlow()

    private var mediaType: MediaType = MediaType.MOVIE
    private var listingType: ListingType = ListingType.TOP_RATED
    private var searchQuery = ""

    private var fetchJob: Job? = null
    private var paginationJob: Job? = null

    init {
        observeSearchQuery()
    }

    fun onEvent(event: ListingEvent) {
        when (event) {
            is ListingEvent.OnSearchQueryChanged -> {
                onSearchQueryChanged(event.query)
            }
        }
    }

    fun onIntent(intent: ListingIntent) {
        when (intent) {

            is ListingIntent.FetchListingData -> {
                mediaType = intent.mediaType
                listingType = intent.listingType
                fetchData()
            }

            ListingIntent.LoadNextPage -> {
                loadNextPage()
            }

            ListingIntent.Retry -> {
                fetchData()
            }
        }
    }

    private fun observeSearchQuery() {

        viewModelScope.launch {

            state
                .map { it.query }
                .debounce(500)
                .distinctUntilChanged()
                .collectLatest { query ->

                    // Search logic should only run on SEARCH listing
                    if (listingType != ListingType.SEARCH) {
                        return@collectLatest
                    }

                    if (query.isBlank()) {

                        searchQuery = ""

                        _state.update {
                            it.copy(
                                results = emptyList(),
                                currentPage = 1,
                                endReached = false,
                                error = null
                            )
                        }

                    } else {

                        searchMovies(query)
                    }
                }
        }
    }

    private suspend fun searchMovies(query: String) {

        searchQuery = query

        _state.update {
            it.copy(
                isLoading = true,
                error = null,
                currentPage = 1,
                endReached = false
            )
        }

        try {

            val result = searchUseCase(
                page = 1,
                query = query
            )

            _state.update {
                it.copy(
                    results = result,
                    isLoading = false,
                    currentPage = 1,
                    endReached = result.size < 20,
                    error = null
                )
            }

        } catch (e: CancellationException) {

            throw e

        } catch (e: Exception) {

            _state.update {
                it.copy(
                    isLoading = false,
                    error = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun onEvent(intent: ListingIntent) {
        when (intent) {

            is ListingIntent.FetchListingData -> {

                mediaType = intent.mediaType
                listingType = intent.listingType

                fetchData()
            }

            ListingIntent.LoadNextPage -> {
                loadNextPage()
            }

            ListingIntent.Retry -> {
                fetchData()
            }
        }
    }

    fun onSearchQueryChanged(query: String) {

        _state.update {
            it.copy(query = query)
        }
    }

    private fun fetchData() {

        /*
         * Cancel any previous first-page request.
         *
         * This prevents an old Trending/Popular/Top Rated
         * request from updating the screen after we navigate
         * to another listing.
         */
        fetchJob?.cancel()

        /*
         * Also cancel pagination from the previous listing.
         */
        paginationJob?.cancel()

        fetchJob = viewModelScope.launch {

            _state.update {
                it.copy(
                    results = emptyList(),
                    isLoading = true,
                    isLoadingMore = false,
                    error = null,
                    currentPage = 1,
                    endReached = false
                )
            }

            try {

                val movies = when (listingType) {

                    ListingType.POPULAR -> {

                        getPopularMoviesUseCase(
                            page = 1,
                            mediaType
                        )
                    }

                    ListingType.TOP_RATED -> {

                        getTopRatedMoviesUseCase(
                            page = 1,
                            mediaType
                        )
                    }

                    ListingType.TRENDING -> {

                        getTrendingUseCase(
                            page = 1,
                            mediaType
                        )
                    }

                    ListingType.SEARCH -> {

                        searchUseCase(
                            page = 1,
                            searchQuery
                        )
                    }
                }

                /*
                 * The coroutine may have been cancelled while the
                 * API request was running.
                 *
                 * Don't update the state in that case.
                 */
                if (!isActive) return@launch

                _state.update {
                    it.copy(
                        results = movies,
                        isLoading = false,
                        currentPage = 1,
                        endReached = movies.size < 20,
                        error = null
                    )
                }

            } catch (e: CancellationException) {

                throw e

            } catch (e: Exception) {

                if (!isActive) return@launch

                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Something went wrong"
                    )
                }
            }
        }
    }

    private fun loadNextPage() {

        val currentState = _state.value


        if (currentState.isLoading) return


        if (currentState.isLoadingMore) return

        if (currentState.endReached) return


        _state.update {
            it.copy(
                isLoadingMore = true,
                error = null
            )
        }

        paginationJob?.cancel()

        paginationJob = viewModelScope.launch {

            val nextPage = currentState.currentPage + 1

            try {

                val movies = when (listingType) {

                    ListingType.POPULAR -> {

                        getPopularMoviesUseCase(
                            page = nextPage,
                            mediaType
                        )
                    }

                    ListingType.TOP_RATED -> {

                        getTopRatedMoviesUseCase(
                            page = nextPage,
                            mediaType
                        )
                    }

                    ListingType.TRENDING -> {

                        getTrendingUseCase(
                            page = nextPage,
                            mediaType
                        )
                    }

                    ListingType.SEARCH -> {

                        searchUseCase(
                            page = nextPage,
                            searchQuery
                        )
                    }
                }

                if (!isActive) return@launch

                _state.update {

                    it.copy(
                        results = it.results + movies,
                        currentPage = nextPage,
                        isLoadingMore = false,
                        endReached = movies.size < 20,
                        error = null
                    )
                }

            } catch (e: CancellationException) {

                throw e

            } catch (e: Exception) {

                if (!isActive) return@launch

                _state.update {

                    it.copy(
                        isLoadingMore = false,
                        error = e.message ?: "Something went wrong"
                    )
                }
            }
        }
    }

    override fun onCleared() {
        fetchJob?.cancel()
        paginationJob?.cancel()
        super.onCleared()
    }
}