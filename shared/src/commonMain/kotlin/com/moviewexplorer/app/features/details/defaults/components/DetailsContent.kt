package com.moviewexplorer.app.features.details.defaults.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.core.utils.SectionTitleStyle
import com.moviewexplorer.app.core.utils.YoutubeLauncher
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Credits
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.domain.model.Review
import com.moviewexplorer.app.domain.model.Video
import com.moviewexplorer.app.features.details.defaults.components.banner.DetailsScreenBanners
import com.moviewexplorer.app.features.details.defaults.components.gallery.ImageGallery
import com.moviewexplorer.app.features.details.defaults.components.review.ReviewScreen
import com.moviewexplorer.app.features.details.defaults.components.topBar.DetailsTopBar
import com.moviewexplorer.app.features.home.defaults.components.ContentSection

@Composable
fun DetailsContent(
    onBackPress: () -> Unit,
    banners: List<Banner>,
    credits: Credits,
    movie: Movie,
    recommendations: List<Movie>,
    similar: List<Movie>,
    videos: List<Video>,
    reviews: List<Review>,
    mediaType: MediaType,
    viewAllImages : () -> Unit,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current

    val listState = rememberLazyListState()

    val elevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 80
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {

        stickyHeader {
            DetailsTopBar(
                onBackPress = onBackPress,
                title = movie.originalTitle,
                elevated = elevated
            )
        }

        item {
            DetailsScreenBanners(
                banners = banners,
                movie = movie
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            CastView(
                credits.casts
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            CrewView(
                credits.crew
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        if (videos.isNotEmpty()) {



            item {
                TrailerView(
                    videos[0],
                    openYoutube = {
                        YoutubeLauncher.openVideo(it)
                    }
                )
            }

            item {
                SpaceVertical(dimens.sectionSpacing)
            }
        }

        item {
            ContentSection(
                title = "RECOMMENDED FOR YOU",
                movieList = recommendations,
                onDetailsScreen = { id ->
                    onDetailsScreen(id)
                },
                titleStyle = SectionTitleStyle.DETAILS
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ContentSection(
                title = if(mediaType == MediaType.MOVIE) "SIMILAR MOVIES" else "SIMILAR TV SHOWS",
                movieList = similar,
                onDetailsScreen = {
                    onDetailsScreen(it)
                },
                titleStyle = SectionTitleStyle.DETAILS
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            DetailTitles(
                "QUICK FACTS"
            )
        }

        item {
            SpaceVertical(dimens.itemSpacing)
        }

        item {
            QuickFacts(
                movie
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }


        if(reviews.isNotEmpty()){
            item {
                DetailTitles(
                    title = "REVIEWS",
                    showViewAll = true
                )
            }

            item {
                SpaceVertical(dimens.itemSpacing)
            }

            item {
                ReviewScreen(
                    reviews
                )
            }

            item {
                SpaceVertical(dimens.sectionSpacing)
            }
        }




        item {
            DetailTitles(
                "Image Gallery"
            )
        }

        item {
            SpaceVertical(dimens.itemSpacing)
        }

        item {
            ImageGallery(
                banners,
                onViewAll = {
                    viewAllImages()
                })
        }
    }
}