package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.shimmer(): Modifier {

    val transition = rememberInfiniteTransition(
        label = "Shimmer"
    )

    val translateX by transition.animateFloat(
        initialValue = -500f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ShimmerTranslate"
    )

    return this.background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFF303030),
                Color(0xFF505050),
                Color(0xFF303030)
            ),
            start = Offset(
                translateX,
                0f
            ),
            end = Offset(
                translateX + 250f,
                250f
            )
        )
    )
}