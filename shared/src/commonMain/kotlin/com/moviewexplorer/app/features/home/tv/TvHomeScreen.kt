package com.moviewexplorer.app.features.home.tv


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.shimmers.tv.TvHomeShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.home.common.HomeIntent
import com.moviewexplorer.app.features.home.common.HomeViewModel
import com.moviewexplorer.app.features.home.tv.components.TvHomeContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TvHomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    onSettingsClick: () -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit
) {

    val state by viewModel.state.collectAsState()



    LaunchedEffect(Unit) {
        if (state.nowPlayingMovies.isEmpty()) {
            viewModel.onIntent(HomeIntent.FetchHomeData)
        }
    }

    when {

        state.isLoading -> {
            //LoaderView()
            TvHomeShimmer()
        }

        state.error != null -> {
            ErrorView(
                state.error!!,
                onRetry = {
                    viewModel.onIntent(HomeIntent.Retry)
                }
            )
        }

        else -> {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.Background)
            ) {

                TvHomeContent(
                    state.nowPlayingMovies,
                    state.popularMovies,
                    state.popularTv,
                    state.topRatedMovies,
                    state.topRatedTv,
                    state.discoverMovies,
                    state.discoverTv,
                    onDetailsScreen = { id, mediaType ->
                        onDetailsScreen(id, mediaType)
                    },
                    onSettingsClick = {
                        onSettingsClick()
                    },
                    onListingScreen = {
                        onListingScreen(it)
                    }
                )
            }
        }
    }
}