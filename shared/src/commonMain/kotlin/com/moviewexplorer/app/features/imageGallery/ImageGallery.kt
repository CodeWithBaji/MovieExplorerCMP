package com.moviewexplorer.app.features.imageGallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.shimmers.images.ImageGalleryShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.GalleryDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.details.common.DetailsIntent
import com.moviewexplorer.app.features.details.common.DetailsViewModel
import com.moviewexplorer.app.features.details.defaults.components.gallery.GalleryItem
import com.moviewexplorer.app.features.details.defaults.components.topBar.DetailsTopBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ImageGallery(
    onBackPress: () -> Unit,
    movieId: Int,
    mediaType: MediaType,
    viewModel: DetailsViewModel = koinViewModel()
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(movieId, mediaType) {
        viewModel.onIntent(
            DetailsIntent.FetchDetailsData(
                movieId = movieId,
                mediaType = mediaType
            )
        )
    }

    when {
        state.isLoading -> {
            ImageGalleryShimmer()
        }

        state.error != null -> {
            ErrorView(
                state.error!!,
                onRetry = {
                    viewModel.onIntent(DetailsIntent.Retry)
                }
            )
        }

        else -> {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.Background)
            ) {



                stickyHeader {

                    DetailsTopBar(
                        elevated = true,
                        title = "Image Gallery",
                        onBackPress = onBackPress
                    )
                }



                item {

                    SpaceVertical(dimens.sectionSpacing)

                    BoxWithConstraints(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimens.screenPadding)
                    ) {

                        val columns = GalleryDefaults.columns(windowType)

                        val totalSpacing =
                            dimens.cardSpacing * (columns - 1)

                        val itemWidth =
                            (maxWidth - totalSpacing) / columns

                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            maxItemsInEachRow = columns,
                            horizontalArrangement = Arrangement.spacedBy(
                                dimens.cardSpacing
                            ),
                            verticalArrangement = Arrangement.spacedBy(
                                dimens.cardSpacing
                            )
                        ) {

                            state.banners.forEach { banner ->

                                GalleryItem(
                                    banner = banner,
                                    width = itemWidth,
                                    height = GalleryDefaults.imageHeight(
                                        windowType
                                    )
                                )
                            }
                        }
                    }

                    SpaceVertical(dimens.sectionSpacing)
                }
            }
        }
    }
}