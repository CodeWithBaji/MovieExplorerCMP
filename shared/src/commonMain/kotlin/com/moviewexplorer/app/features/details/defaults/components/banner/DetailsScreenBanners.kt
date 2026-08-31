package com.moviewexplorer.app.features.details.defaults.components.banner

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun DetailsScreenBanners(
    banners: List<Banner>,
    movie: Movie,
    modifier: Modifier = Modifier
) {

    if (banners.isEmpty()) return

    var currentIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    LaunchedEffect(banners.size) {
        while (true) {
            delay(5000)

            currentIndex =
                (currentIndex + 1) % banners.size
        }
    }

    Crossfade(
        targetState = currentIndex,
        animationSpec = tween(
            durationMillis = 800,
            easing = FastOutSlowInEasing
        ),
        label = "DetailsBannerAnimation",
        modifier = modifier.fillMaxWidth()
    ) { index ->

        DetailsBanner(
            banner = banners[index],
            movie = movie
        )
    }
}