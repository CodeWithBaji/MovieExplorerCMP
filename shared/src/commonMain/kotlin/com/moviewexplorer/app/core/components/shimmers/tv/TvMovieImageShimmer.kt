package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun TvMovieImageShimmer() {

    val transition = rememberInfiniteTransition(
        label = "MovieImageShimmer"
    )

    val shimmerX by transition.animateFloat(
        initialValue = -1f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1100,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ShimmerX"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF151515),
                        Color(0xFF222226),
                        Color(0xFF151515)
                    ),
                    start = androidx.compose.ui.geometry.Offset(
                        shimmerX * 500f,
                        0f
                    ),
                    end = androidx.compose.ui.geometry.Offset(
                        shimmerX * 500f + 250f,
                        250f
                    )
                )
            )
    )
}