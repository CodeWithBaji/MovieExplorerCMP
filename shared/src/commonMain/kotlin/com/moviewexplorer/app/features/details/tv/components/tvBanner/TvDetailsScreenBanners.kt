package com.moviewexplorer.app.features.details.tv.components.tvBanner

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun TvDetailsScreenBanners(
    banners: List<Banner>,
    movie: Movie,
    modifier: Modifier = Modifier,
    watchRequester: FocusRequester,
    watchListRequester: FocusRequester,
    upRequester: FocusRequester,
    downRequester: FocusRequester,
    castRequester: FocusRequester
) {

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    var buttonsFocused by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(banners.size, buttonsFocused) {

        if (buttonsFocused) {
            return@LaunchedEffect
        }

        while (true) {

            delay(5000)

            currentIndex =
                (currentIndex + 1) % banners.size
        }
    }

    Crossfade(
        targetState = currentIndex,
        animationSpec = tween(800),
        label = "BannerAnimation",
        modifier = modifier.fillMaxWidth()
    ) { index ->

        TvDetailsBanner(
            banner = banners[index],
            movie = movie,
            watchRequester = watchRequester,
            watchListRequester = watchListRequester,
            upRequester = upRequester,
            downRequester = downRequester,
            castRequester = castRequester,
            onButtonFocusChanged = {
                buttonsFocused = it
            }
        )
    }
}

