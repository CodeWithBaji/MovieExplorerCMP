package com.moviewexplorer.app.features.details.tv.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.core.utils.YoutubeLauncher
import com.moviewexplorer.app.core.utils.safeRequestFocus
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Credits
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.domain.model.Review
import com.moviewexplorer.app.domain.model.Video
import com.moviewexplorer.app.features.details.tv.TvDetailsFocusState
import com.moviewexplorer.app.features.details.tv.components.creditsSection.TvCastView
import com.moviewexplorer.app.features.details.tv.components.creditsSection.TvCrewView
import com.moviewexplorer.app.features.details.tv.components.facts.TvQuickFacts
import com.moviewexplorer.app.features.details.tv.components.gallery.TvImageGallery
import com.moviewexplorer.app.features.details.tv.components.reviews.TvReviewBottomSheet
import com.moviewexplorer.app.features.details.tv.components.reviews.TvReviewsView
import com.moviewexplorer.app.features.details.tv.components.tvBanner.TvDetailsScreenBanners
import com.moviewexplorer.app.features.details.tv.components.tvTopBar.TvDetailsTopBar
import kotlinx.coroutines.launch

@Composable
fun TvDetailsContent(
    onBackPress: () -> Unit,
    banners: List<Banner>,
    credits: Credits,
    movie: Movie,
    recommendations: List<Movie>,
    similar: List<Movie>,
    videos: List<Video>,
    reviews: List<Review>,
    mediaType: MediaType,
    viewAllImages: () -> Unit,
    onDetailsScreen: (id: Int) -> Unit
) {

    val focusState = remember {
        TvDetailsFocusState()
    }

    val dimens = LocalTvDimens.current
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()


    val castRequester = remember {
        FocusRequester()
    }

    val crewRequester = remember {
        FocusRequester()
    }

    val trailerRequester = remember {
        FocusRequester()
    }

    val recommendedRequester = remember {
        FocusRequester()
    }

    val similarRequester = remember {
        FocusRequester()
    }



    val quickFactsRequester = remember {
        FocusRequester()
    }

    val reviewsRequester = remember {
        FocusRequester()
    }

    var reviewForBottomSheet by remember {
        mutableStateOf<Review?>(null)
    }


    val galleryRequester = remember { FocusRequester() }



    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(200)
        focusState.back.safeRequestFocus()
    }


    val elevated by remember {

        derivedStateOf {

            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 80
        }
    }


    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            bottom = 80.dp
        )
    ) {


        stickyHeader {

            TvDetailsTopBar(
                onBackPress = onBackPress,
                title = movie.originalTitle,
                elevated = elevated,

                focusRequester = focusState.back,

                downRequester = focusState.watchNow
            )
        }


        item {

            TvDetailsScreenBanners(
                banners = banners,
                movie = movie,

                watchRequester = focusState.watchNow,

                watchListRequester = focusState.watchList,

                upRequester = focusState.back,

                downRequester = castRequester,

                castRequester = castRequester
            )
        }

        item {
            SpaceVertical(
                dimens.sectionSpacing
            )
        }


        if (credits.casts.isNotEmpty()) {

            item {

                TvCastView(
                    casts = credits.casts,

                    firstItemRequester = castRequester,

                    onUp = {
                        scope.launch {
                            focusState.watchList.safeRequestFocus()
                        }
                    },

                    onDown = {
                        if (credits.crew.isNotEmpty()) {
                            scope.launch {
                                crewRequester.safeRequestFocus()
                            }
                        } else {
                            scope.launch {
                                trailerRequester.safeRequestFocus()
                            }
                        }
                    }
                )
            }

            item {
                SpaceVertical(
                    dimens.sectionSpacing
                )
            }
        }


        if (credits.crew.isNotEmpty()) {

            item {

                TvCrewView(
                    crews = credits.crew,

                    firstItemRequester = crewRequester,

                    onUp = {
                        if (credits.casts.isNotEmpty()) {
                            scope.launch {
                                castRequester.safeRequestFocus()
                            }
                        } else {
                            scope.launch {
                                focusState.watchList.safeRequestFocus()
                            }
                        }
                    },

                    onDown = {
                        if (videos.isNotEmpty()) {
                            scope.launch {
                                trailerRequester.safeRequestFocus()
                            }
                        } else if (recommendations.isNotEmpty()) {
                            scope.launch {
                                recommendedRequester.safeRequestFocus()
                            }
                        }
                    }
                )
            }

            item {
                SpaceVertical(
                    dimens.sectionSpacing
                )
            }
        }


        if (videos.isNotEmpty()) {

            item {

                TvTrailerView(
                    video = videos.first(),

                    openYoutube = { videoId ->
                        YoutubeLauncher.openVideo(videoId)
                    },

                    focusRequester = trailerRequester,

                    upRequester = if (credits.crew.isNotEmpty()) {
                        crewRequester
                    } else if (credits.casts.isNotEmpty()) {
                        castRequester
                    } else {
                        focusState.watchList
                    },

                    downRequester = if (recommendations.isNotEmpty()) {
                        recommendedRequester
                    } else if (similar.isNotEmpty()) {
                        similarRequester
                    } else {
                        null
                    }
                )
            }

            item {
                SpaceVertical(
                    dimens.sectionSpacing
                )
            }
        }


        if (recommendations.isNotEmpty()) {

            item {

                TvRecommendationsView(
                    movies = recommendations,

                    firstItemRequester = recommendedRequester,

                    upRequester = if (videos.isNotEmpty()) {
                        trailerRequester
                    } else if (credits.crew.isNotEmpty()) {
                        crewRequester
                    } else if (credits.casts.isNotEmpty()) {
                        castRequester
                    } else {
                        focusState.watchList
                    },

                    downRequester = if (similar.isNotEmpty()) {
                        similarRequester
                    } else {
                        null
                    },

                    onMovieClick = { id ->
                        onDetailsScreen(id)
                    }
                )
            }

            item {
                SpaceVertical(
                    dimens.sectionSpacing
                )
            }
        }


        if (similar.isNotEmpty()) {

            item {

                TvSimilarMoviesView(
                    movies = similar,

                    firstItemRequester = similarRequester,

                    upRequester = if (recommendations.isNotEmpty()) {
                        recommendedRequester
                    } else if (videos.isNotEmpty()) {
                        trailerRequester
                    } else if (credits.crew.isNotEmpty()) {
                        crewRequester
                    } else if (credits.casts.isNotEmpty()) {
                        castRequester
                    } else {
                        focusState.watchList
                    },

                    downRequester = quickFactsRequester,

                    onMovieClick = { id ->
                        onDetailsScreen(id)
                    }
                )
            }
        }

        item {
            SpaceVertical(
                dimens.sectionSpacing
            )
        }

        item {
            TvDetailTitles(
                title = "QUICK FACTS"
            )
        }

        item {
            SpaceVertical(
                dimens.itemSpacing
            )
        }

        item {

            TvQuickFacts(
                movie = movie,
                focusRequester = quickFactsRequester,

                onUp = {

                    when {
                        similar.isNotEmpty() -> {
                            similarRequester.safeRequestFocus()
                        }

                        recommendations.isNotEmpty() -> {
                            recommendedRequester.safeRequestFocus()
                        }

                        videos.isNotEmpty() -> {
                            trailerRequester.safeRequestFocus()
                        }

                        credits.crew.isNotEmpty() -> {
                            crewRequester.safeRequestFocus()
                        }

                        credits.casts.isNotEmpty() -> {
                            castRequester.safeRequestFocus()
                        }

                        else -> {
                            focusState.watchList.safeRequestFocus()
                        }
                    }
                },

                // QUICK FACTS ↓
                onDown = {
                    reviewsRequester.safeRequestFocus()
                }
            )
        }

        item {
            SpaceVertical(
                dimens.sectionSpacing
            )
        }

        if (reviews.isNotEmpty()) {

            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimens.screenPadding
                        )
                ) {

                    TvReviewsView(
                        reviews = reviews,

                        firstItemRequester = reviewsRequester,

                        upRequester = {
                            quickFactsRequester.safeRequestFocus()
                        },

                        downRequester = {

                            if (banners.isNotEmpty()) {
                                galleryRequester.safeRequestFocus()
                            }
                        },

                        onOpen = { review ->
                            reviewForBottomSheet = review
                        }
                    )
                }
            }
        }

        item {
            SpaceVertical(
                dimens.sectionSpacing
            )
        }

        if (banners.isNotEmpty()) {

            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimens.screenPadding
                        )
                ) {

                    TvImageGallery(
                        banners = banners,

                        firstItemRequester = galleryRequester,

                        onUp = {
                            reviewsRequester.safeRequestFocus()
                        }
                    )
                }
            }
        }

    }

    reviewForBottomSheet?.let { review ->

        TvReviewBottomSheet(
            review = review,

            onDismiss = {
                reviewForBottomSheet = null
            }
        )
    }
}