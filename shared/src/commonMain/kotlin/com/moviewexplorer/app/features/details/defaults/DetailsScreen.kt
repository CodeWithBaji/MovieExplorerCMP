package com.moviewexplorer.app.features.details.defaults

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.shimmers.details.DetailsShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.details.common.DetailsIntent
import com.moviewexplorer.app.features.details.common.DetailsViewModel
import com.moviewexplorer.app.features.details.defaults.components.DetailsContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsScreen(
    onBackPress: () -> Unit,
    viewModel: DetailsViewModel = koinViewModel(),
    movieId: Int,
    mediaType: MediaType,
    viewAllImages: (movieId: Int, mediaType: MediaType) -> Unit,
    onViewDetails: (movieId: Int, mediaType: MediaType) -> Unit
){

    val state by viewModel.state.collectAsState()



    LaunchedEffect(movieId) {
        if (state.banners.isEmpty()) {
            viewModel.onIntent(DetailsIntent.FetchDetailsData(movieId, mediaType))
        }

    }

    when {
        state.isLoading -> {
            //LoaderView()
            DetailsShimmer()
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(DetailsIntent.Retry)
            })
        }

        else ->{

            Box(
                modifier = Modifier.fillMaxSize()
                    .background(AppColors.Background)
            ){

                state.details?.let {
                    DetailsContent(
                        onBackPress = {
                            onBackPress()
                        },
                        state.banners,
                        credits = state.credits!!,
                        it,
                        state.recommendedMovies,
                        state.similarMovies,
                        state.videos,
                        state.reviews,
                        mediaType,
                        viewAllImages = {
                            viewAllImages(movieId, mediaType)
                        },
                        onDetailsScreen = { id ->
                            onViewDetails(id, mediaType)
                        }
                    )
                }

            }

        }

    }


}