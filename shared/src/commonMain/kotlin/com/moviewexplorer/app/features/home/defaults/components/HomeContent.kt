package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.features.home.defaults.components.bottomNavBar.BottomNavItem
import com.moviewexplorer.app.features.home.defaults.components.bottomNavBar.MovieBottomNavigation
import com.moviewexplorer.app.features.home.defaults.components.collapsBanner.CollapsedHomeBanner
import com.moviewexplorer.app.features.home.defaults.components.topbar.TopBar
import kotlinx.coroutines.delay

@Composable
fun HomeContent(
    moviesList: List<Movie>,
    tvList: List<Movie>,
    topRatedMovies: List<Movie>,
    topRatedTv: List<Movie>,
    nowPlaying: List<Movie>,
    popularMovies: List<Movie>,
    popularTv: List<Movie>,
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit,
    onSettingsClick: () -> Unit
) {

    val listState = rememberLazyListState()
    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val isMobile = windowType == WindowType.Compact

    var currentBannerIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    LaunchedEffect(nowPlaying.size) {
        if (nowPlaying.isEmpty()) return@LaunchedEffect

        while (true) {
            delay(5000)

            currentBannerIndex =
                (currentBannerIndex + 1) % minOf(nowPlaying.size, 5)
        }
    }

    val collapsedBannerProgress by remember {
        derivedStateOf {
            if (!isMobile) {
                0f
            } else if (listState.firstVisibleItemIndex > 0) {
                1f
            } else {
                val scrollOffset = listState.firstVisibleItemScrollOffset.toFloat()

                val startCollapseAt = 300f
                val fullyCollapsedAt = 500f

                ((scrollOffset - startCollapseAt) /
                        (fullyCollapsedAt - startCollapseAt))
                    .coerceIn(0f, 1f)
            }
        }
    }

    val elevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 80
        }
    }

    Scaffold(
        containerColor = AppColors.Background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.Background),
                contentPadding = PaddingValues(
                    bottom = if (isMobile) {
                        110.dp
                    } else {
                        dimens.sectionSpacing
                    }
                )
            ) {

                if (!isMobile) {
                    stickyHeader {
                        TopBar(
                            elevated = elevated,
                            onListingScreen = onListingScreen,
                            onSettingsClick = onSettingsClick
                        )
                    }
                }

                item(
                    key = "home_banner"
                ) {
                    BannerSlider(
                        banners = nowPlaying.take(5),
                        currentIndex = currentBannerIndex,
                        onDetailsScreen = { id ->
                            onDetailsScreen(
                                id,
                                MediaType.MOVIE
                            )
                        }
                    )
                }

                if (isMobile) {

                    item {
                        SpaceVertical(dimens.sectionSpacing)
                    }

                    item(
                        key = "explore"
                    ) {
                        ExploreSection(
                            onListingScreen = onListingScreen
                        )
                    }
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }

                item(
                    key = "popular_movies"
                ) {
                    ContentSection(
                        title = "Popular Movies",
                        movieList = popularMovies,
                        onDetailsScreen = { id ->
                            onDetailsScreen(
                                id,
                                MediaType.MOVIE
                            )
                        }
                    )
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }

                item(
                    key = "popular_tv"
                ) {
                    ContentSection(
                        title = "Popular TV Shows",
                        movieList = popularTv,
                        onDetailsScreen = { id ->
                            onDetailsScreen(
                                id,
                                MediaType.TV
                            )
                        }
                    )
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }

                item(
                    key = "top_rated_movies"
                ) {
                    ContentSection(
                        title = "Top Rated Movies",
                        movieList = topRatedMovies,
                        onDetailsScreen = { id ->
                            onDetailsScreen(
                                id,
                                MediaType.MOVIE
                            )
                        }
                    )
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }

                item(
                    key = "top_rated_tv"
                ) {
                    ContentSection(
                        title = "Top Rated TV Shows",
                        movieList = topRatedTv,
                        onDetailsScreen = { id ->
                            onDetailsScreen(
                                id,
                                MediaType.TV
                            )
                        }
                    )
                }

                if (moviesList.isNotEmpty()) {

                    item {
                        SpaceVertical(dimens.sectionSpacing)
                    }

                    item(
                        key = "watchlist_movies"
                    ) {
                        ContentSection(
                            title = "Watchlist Movies",
                            movieList = moviesList,
                            onDetailsScreen = { id ->
                                onDetailsScreen(
                                    id,
                                    MediaType.MOVIE
                                )
                            }
                        )
                    }
                }

                if (tvList.isNotEmpty()) {

                    item {
                        SpaceVertical(dimens.sectionSpacing)
                    }

                    item(
                        key = "watchlist_tv"
                    ) {
                        ContentSection(
                            title = "Watchlist TV Shows",
                            movieList = tvList,
                            onDetailsScreen = { id ->
                                onDetailsScreen(
                                    id,
                                    MediaType.TV
                                )
                            }
                        )
                    }
                }

                item {
                    SpaceVertical(dimens.sectionSpacing)
                }
            }

            //collaps banner
            val bannerMovies = nowPlaying.take(5)
            if (
                isMobile &&
                collapsedBannerProgress > 0f &&
                nowPlaying.isNotEmpty()
            ) {

                CollapsedHomeBanner(
                    movie = bannerMovies[currentBannerIndex],
                    onDetailsScreen = { id ->
                        onDetailsScreen(
                            id,
                            MediaType.MOVIE
                        )
                    },
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .graphicsLayer {

                            alpha = collapsedBannerProgress

                            translationY =
                                -(1f - collapsedBannerProgress) * 40f
                        }
                )
            }

            //bottom navigation bar for mobile apps
            if (isMobile) {
                MovieBottomNavigation(
                    selectedItem = BottomNavItem.Home,
                    onItemSelected = { item ->

                        when (item) {
                            BottomNavItem.Home -> Unit

                            BottomNavItem.Search -> {
                                onListingScreen(ListingType.SEARCH)
                            }

                            BottomNavItem.Watchlist -> {
                                // navigate watchlist
                            }

                            BottomNavItem.Settings -> {
                                // navigate settings
                                onSettingsClick()
                            }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}