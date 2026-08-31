package com.moviewexplorer.app.features.listingScreen.defaults

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.shimmers.listings.ListingShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.details.defaults.components.topBar.DetailsTopBar
import com.moviewexplorer.app.features.home.defaults.components.CardsView
import com.moviewexplorer.app.features.listingScreen.ListingEvent
import com.moviewexplorer.app.features.listingScreen.ListingIntent
import com.moviewexplorer.app.features.listingScreen.ListingViewModel
import com.moviewexplorer.app.features.listingScreen.defaults.components.ListingMediaSelector
import com.moviewexplorer.app.features.listingScreen.defaults.components.ListingPaginationLoader
import com.moviewexplorer.app.features.listingScreen.defaults.components.NoSearchResult
import com.moviewexplorer.app.features.listingScreen.defaults.components.SearchEmptyState
import kotlinx.coroutines.flow.distinctUntilChanged
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListingScreen(
    listingType: ListingType,
    onBackPress: () -> Unit = {},
    viewModel: ListingViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    var selectedMediaType by rememberSaveable {
        mutableStateOf(MediaType.MOVIE)
    }

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val columns = when (windowType) {
        WindowType.Compact -> 3
        WindowType.Medium -> 4
        WindowType.Expanded -> 7
    }

    val movieRows = remember(state.results, columns) {
        state.results.chunked(columns)
    }

    val listState = rememberLazyListState()


    LaunchedEffect(listingType, selectedMediaType) {

        viewModel.onIntent(
            ListingIntent.FetchListingData(
                mediaType = selectedMediaType,
                listingType = listingType
            )
        )
    }


    LaunchedEffect(listState) {

        snapshotFlow {

            val layoutInfo = listState.layoutInfo

            val lastVisibleItem =
                layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0

            val totalItems =
                layoutInfo.totalItemsCount

            val shouldLoadMore =
                totalItems > 0 &&
                        lastVisibleItem >= totalItems - 3

            shouldLoadMore
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

            ListingShimmer(
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
                    .background(AppColors.Background),
                contentPadding = PaddingValues(
                    bottom = dimens.sectionSpacing
                )
            ) {


                stickyHeader {

                    DetailsTopBar(
                        elevated = true,
                        onBackPress = onBackPress,
                        title = listingTitle(listingType),
                        showSearchBar = listingType == ListingType.SEARCH,
                        searchQuery = state.query,
                        onSearchQueryChange = { query ->

                            viewModel.onEvent(
                                ListingEvent.OnSearchQueryChanged(
                                    query
                                )
                            )
                        }
                    )
                }


                if (listingType != ListingType.SEARCH) {

                    item {

                        ListingMediaSelector(
                            selectedMediaType = selectedMediaType,
                            onMediaTypeSelected = {
                                selectedMediaType = it
                            }
                        )
                    }
                }


                if (
                    listingType == ListingType.SEARCH &&
                    state.query.isBlank()
                ) {

                    item {

                        SearchEmptyState(
                            modifier = Modifier
                                .fillParentMaxSize()
                        )
                    }
                }


                else if (
                    listingType == ListingType.SEARCH &&
                    state.query.isNotBlank() &&
                    state.results.isEmpty()
                ) {

                    item {

                        NoSearchResult(
                            query = state.query,
                            modifier = Modifier
                                .fillParentMaxSize()
                        )
                    }
                }


                else {

                    items(
                        items = movieRows,
                        key = { row ->
                            row.firstOrNull()?.id ?: row.hashCode()
                        }
                    ) { row ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = dimens.screenPadding
                                ),
                            horizontalArrangement = Arrangement.spacedBy(
                                dimens.cardSpacing
                            )
                        ) {

                            row.forEach { movie ->

                                CardsView(
                                    movie = movie,
                                    modifier = Modifier.weight(1f),
                                    onDetailsScreen = { id ->

                                        val mediaType =
                                            when (movie.mediaType) {

                                                "movie" ->
                                                    MediaType.MOVIE

                                                "tv" ->
                                                    MediaType.TV

                                                else ->
                                                    selectedMediaType
                                            }

                                        onDetailsScreen(
                                            id,
                                            mediaType
                                        )
                                    }
                                )
                            }


                            repeat(columns - row.size) {

                                Spacer(
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        SpaceVertical(
                            dimens.sectionSpacing
                        )
                    }
                }


                if (state.isLoadingMore) {

                    item {

                        ListingPaginationLoader()
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

