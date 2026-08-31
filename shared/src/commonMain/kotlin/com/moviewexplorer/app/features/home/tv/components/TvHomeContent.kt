package com.moviewexplorer.app.features.home.tv.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.utils.HomeRow
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.tv.TvHomeFocusState
import kotlinx.coroutines.launch

@Composable
fun TvHomeContent(
    banners: List<Movie>,
    popularMovies: List<Movie>,
    popularTv: List<Movie>,
    topRatedMovies: List<Movie>,
    topRatedTv: List<Movie>,
    watchListMovies: List<Movie>,
    watchListTv: List<Movie>,
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    onSettingsClick: () -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit
) {

    val focusState = remember {
        TvHomeFocusState()
    }

    val homeListState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    var initialFocusRequested by rememberSaveable {
        mutableStateOf(false)
    }

    val dimens = LocalTvDimens.current

    LazyColumn(
        state = homeListState,
        modifier = Modifier.fillMaxSize()
    ) {


        item {

            TvTopBar(
                focusRequester = focusState.topBar,
                downRequester = focusState.watchNow,

                trendingRequester = focusState.trending,
                popularRequester = focusState.popular,
                topRatedRequester = focusState.topRated,
                searchRequester = focusState.search,
                settingsRequester = focusState.settings,

                onHomeClick = {},
                onTrendingClick = {
                    onListingScreen(ListingType.TRENDING)
                },
                onPopularClick = {
                    onListingScreen(ListingType.POPULAR)
                },
                onTopRatedClick = {
                    onListingScreen(ListingType.TOP_RATED)
                },
                onSearchClick = {
                    onListingScreen(ListingType.SEARCH)
                },
                onSettingsClick = {
                    onSettingsClick()
                },

                onInitialFocusRequested = {
                    initialFocusRequested = true
                },

                requestInitialFocus = !initialFocusRequested
            )
        }


        item {

            TvBannerSlider(
                watchRequester = focusState.watchNow,
                upRequester = focusState.topBar,
                downRequester = focusState.popularMovie,

                banners = banners,

                onDetailsScreen = { movieId ->
                    onDetailsScreen(
                        movieId,
                        MediaType.MOVIE
                    )
                },

                onWatchNow = { movieId ->
                    // TODO
                },

                onWatchNowFocused = {
                    scope.launch {
                        homeListState.animateScrollToItem(1)
                    }
                }
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }


        item {

            TvContentRow(
                title = "POPULAR MOVIES",
                movies = popularMovies,

                firstItemRequester = focusState.popularMovie,

                upRequester = focusState.watchNow,
                downRequester = focusState.popularTv,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.MOVIE
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.POPULAR_MOVIES
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }


        item {

            TvContentRow(
                title = "POPULAR TV SHOWS",
                movies = popularTv,

                firstItemRequester = focusState.popularTv,

                upRequester = focusState.popularMovie,
                downRequester = focusState.topRatedMovies,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.TV
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.POPULAR_TV
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }



        item {

            TvContentRow(
                title = "TOP RATED MOVIES",
                movies = topRatedMovies,

                firstItemRequester = focusState.topRatedMovies,

                upRequester = focusState.popularTv,
                downRequester = focusState.topRatedTv,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.MOVIE
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.TOP_RATED_MOVIES
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }



        item {

            TvContentRow(
                title = "TOP RATED TV SHOWS",
                movies = topRatedTv,

                firstItemRequester = focusState.topRatedTv,

                upRequester = focusState.topRatedMovies,
                downRequester = focusState.watchListMovies,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.TV
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.TOP_RATED_TV
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }



        item {

            TvContentRow(
                title = "WATCHLIST MOVIES",
                movies = watchListMovies,

                firstItemRequester = focusState.watchListMovies,

                upRequester = focusState.topRatedTv,
                downRequester = focusState.watchListTvShows,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.MOVIE
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.WATCH_LIST_MOVIE
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }



        item {

            TvContentRow(
                title = "WATCHLIST TV SHOWS",
                movies = watchListTv,

                firstItemRequester = focusState.watchListTvShows,

                upRequester = focusState.watchListMovies,
                downRequester = null,

                onMovieClick = {
                    onDetailsScreen(
                        it,
                        MediaType.TV
                    )
                },

                onFirstCardFocused = { row ->

                    scope.launch {
                        homeListState.animateScrollToItem(
                            index = row.rowIndex,
                            scrollOffset = -120
                        )
                    }
                },

                row = HomeRow.WATCH_LIST_TV
            )
        }
    }
}