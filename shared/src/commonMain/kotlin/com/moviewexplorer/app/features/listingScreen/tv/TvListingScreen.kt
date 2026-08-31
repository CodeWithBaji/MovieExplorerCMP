package com.moviewexplorer.app.features.listingScreen.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.shimmers.tv.TvListingShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.details.tv.components.tvTopBar.TvDetailsTopBar
import com.moviewexplorer.app.features.home.tv.components.TvCardsView
import com.moviewexplorer.app.features.listingScreen.ListingEvent
import com.moviewexplorer.app.features.listingScreen.ListingIntent
import com.moviewexplorer.app.features.listingScreen.ListingViewModel
import com.moviewexplorer.app.features.listingScreen.tv.components.TvListingMediaSelector
import com.moviewexplorer.app.features.listingScreen.tv.components.TvListingPaginationLoader
import com.moviewexplorer.app.features.listingScreen.tv.components.TvNoSearchResult
import com.moviewexplorer.app.features.listingScreen.tv.components.TvSearchEmptyState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TvListingScreen(
    listingType: ListingType,
    onBackPress: () -> Unit = {},
    viewModel: ListingViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    val dimens = LocalTvDimens.current

    val listState = rememberLazyListState()



    fun FocusRequester.safeRequestFocus(): Boolean {
        return try {
            requestFocus()
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    val topBarRequester = remember {
        FocusRequester()
    }

    val firstCardRequester = remember {
        FocusRequester()
    }

    val emptyStateRequester = remember {
        FocusRequester()
    }

    val moviesTabRequester = remember {
        FocusRequester()
    }

    val tvTabRequester = remember {
        FocusRequester()
    }

    var selectedMediaType by rememberSaveable {
        mutableStateOf(MediaType.MOVIE)
    }

    var focusedMediaType by rememberSaveable {
        mutableStateOf(MediaType.MOVIE)
    }



    LaunchedEffect(
        selectedMediaType,
        state.isLoading
    ) {
        if (
            listingType != ListingType.SEARCH &&
            !state.isLoading
        ) {

            delay(100)

            when (focusedMediaType) {

                MediaType.MOVIE -> {
                    moviesTabRequester.safeRequestFocus()
                }

                MediaType.TV -> {
                    tvTabRequester.safeRequestFocus()
                }
            }
        }
    }

    LaunchedEffect(
        selectedMediaType,
        state.isLoading,
        state.isLoadingMore
    ) {

        if (
            listingType != ListingType.SEARCH &&
            !state.isLoading &&
            !state.isLoadingMore
        ) {

            delay(100)

            when (focusedMediaType) {

                MediaType.MOVIE -> {
                    moviesTabRequester.safeRequestFocus()
                }

                MediaType.TV -> {
                    tvTabRequester.safeRequestFocus()
                }
            }
        }
    }


    LaunchedEffect(listingType) {
        selectedMediaType = MediaType.MOVIE
    }

    LaunchedEffect(listingType, selectedMediaType) {

        viewModel.onIntent(
            ListingIntent.FetchListingData(
                mediaType = selectedMediaType,
                listingType = listingType
            )
        )
    }



    val columns = 5

    val movieRows = remember(state.results, columns) {

        state.results
            .distinctBy { movie ->
                "${movie.mediaType}_${movie.id}"
            }
            .chunked(columns)
    }

    LaunchedEffect(
        listState,
        state.isLoading,
        state.isLoadingMore,
        state.endReached,
        movieRows.size
    ) {

        snapshotFlow {

            val layoutInfo = listState.layoutInfo

            val lastVisibleItemIndex =
                layoutInfo.visibleItemsInfo
                    .lastOrNull()
                    ?.index ?: -1

            val totalItems =
                layoutInfo.totalItemsCount

            lastVisibleItemIndex >= totalItems - 2
        }
            .distinctUntilChanged()
            .collect { shouldLoadMore ->

                if (
                    shouldLoadMore &&
                    !state.isLoading &&
                    !state.isLoadingMore &&
                    !state.endReached
                ) {

                    viewModel.onIntent(
                        ListingIntent.LoadNextPage
                    )
                }
            }
    }



    when {



        state.isLoading -> {

            TvListingShimmer(
                columns = columns
            )
        }



        state.error != null -> {

            ErrorView(
                message = state.error!!,
                onRetry = {
                    viewModel.onIntent(
                        ListingIntent.Retry
                    )
                }
            )
        }



        else -> {

            LazyColumn(
                state = listState,

                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        AppColors.Background
                    ),

                contentPadding = PaddingValues(
                    bottom = dimens.sectionSpacing
                )
            ) {



                stickyHeader {

                    TvDetailsTopBar(
                        elevated = true,

                        onBackPress = onBackPress,

                        title = listingTitle(listingType),

                        showSearchBar = listingType == ListingType.SEARCH,

                        searchQuery = state.query,

                        onSearchQueryChange = { query ->

                            viewModel.onEvent(
                                ListingEvent.OnSearchQueryChanged(query)
                            )
                        },

                        focusRequester = topBarRequester,

                        downRequester = if (listingType == ListingType.SEARCH) {
                            firstCardRequester
                        } else {
                            moviesTabRequester
                        }
                    )
                }



                if (listingType != ListingType.SEARCH) {

                    item {

                        TvListingMediaSelector(
                            selectedMediaType = selectedMediaType,

                            moviesRequester = moviesTabRequester,
                            tvRequester = tvTabRequester,
                            firstCardRequester = firstCardRequester,

                            onMediaTypeSelected = { mediaType ->

                                focusedMediaType = mediaType
                                selectedMediaType = mediaType
                            }
                        )
                    }
                }



                if (
                    listingType == ListingType.SEARCH &&
                    state.query.isBlank()
                ) {

                    item {

                        TvSearchEmptyState(
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(
                                    emptyStateRequester
                                )
                                .focusable()
                        )
                    }
                }



                else if (
                    listingType == ListingType.SEARCH &&
                    state.query.isNotBlank() &&
                    state.results.isEmpty()
                ) {

                    item {

                        TvNoSearchResult(
                            query = state.query,

                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(
                                    emptyStateRequester
                                )
                                .focusable()
                        )
                    }
                }



                else {

                    items(
                        items = movieRows,

                        key = { row ->

                            row.firstOrNull()?.let { movie ->
                                "${movie.mediaType}_${movie.id}"
                            } ?: row.hashCode()
                        }
                    ) { row ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = dimens.screenPadding
                                ),

                            horizontalArrangement =
                                Arrangement.spacedBy(
                                    dimens.cardSpacing
                                )
                        ) {

                            row.forEach { movie ->

                                TvCardsView(

                                    movie = movie,

                                    modifier = Modifier
                                        .then(

                                            if (movie == state.results.firstOrNull()) {
                                                Modifier.focusRequester(firstCardRequester)
                                            } else {
                                                Modifier
                                            }
                                        ),

                                    onDetailsScreen = {

                                        val mediaType =
                                            when (
                                                movie.mediaType
                                            ) {

                                                "movie" ->
                                                    MediaType.MOVIE

                                                "tv" ->
                                                    MediaType.TV

                                                else ->
                                                    selectedMediaType
                                            }

                                        onDetailsScreen(
                                            movie.id,
                                            mediaType
                                        )
                                    }
                                )
                            }
                        }

                        SpaceVertical(
                            dimens.sectionSpacing
                        )
                    }



                    if (state.isLoadingMore) {

                        item {

                            TvListingPaginationLoader()
                        }
                    }
                }
            }
        }
    }
}




private fun listingTitle(
    listingType: ListingType
): String {

    return when (listingType) {

        ListingType.TRENDING ->
            "Trending"

        ListingType.POPULAR ->
            "Popular"

        ListingType.TOP_RATED ->
            "Top Rated"

        ListingType.SEARCH ->
            "Search"
    }
}