package com.moviewexplorer.app.features.home.defaults

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.components.ErrorView
import com.moviewexplorer.app.core.components.shimmers.home.HomeShimmer
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.home.common.HomeIntent
import com.moviewexplorer.app.features.home.common.HomeViewModel
import com.moviewexplorer.app.features.home.defaults.components.HomeContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onDetailsScreen: (id: Int, mediaType: MediaType) -> Unit,
    onListingScreen: (listingType: ListingType) -> Unit,
    onSettingsClick: () -> Unit
){


    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        if (state.nowPlayingMovies.isEmpty()) {
            viewModel.onIntent(HomeIntent.FetchHomeData)
        }

    }

    when{
        state.isLoading  ->{
            //LoaderView()
            HomeShimmer(
                isTv = false
            )
        }

        state.error != null -> {
            ErrorView(state.error!!, onRetry = {
                viewModel.onIntent(HomeIntent.Retry)
            })
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(AppColors.Background)
            ){

                HomeContent(
                    state.discoverMovies,
                    state.discoverTv,
                    state.topRatedMovies,
                    state.topRatedTv,
                    state.nowPlayingMovies,
                    state.popularMovies,
                    state.popularTv,
                    onDetailsScreen = { id, mediaType ->
                        onDetailsScreen(id, mediaType)
                    },
                    onListingScreen = {

                        onListingScreen(it)
                    },
                    onSettingsClick = {
                        onSettingsClick()
                    }
                )


            }
        }
    }


}