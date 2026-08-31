package com.moviewexplorer.app.features.splash.tv.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.theme.AppColors


@Composable
fun TvAnimatedBackground(
    modifier: Modifier = Modifier
) {
    // Resolve theme colors in composable scope
    val background = AppColors.Background
    val backgroundSecondary = AppColors.BackgroundSecondary
    val primary = AppColors.Primary

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        background,
                        backgroundSecondary,
                        background
                    )
                )
            )
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {

            val center = Offset(
                x = size.width / 2f,
                y = size.height * 0.42f
            )

            val radius = size.minDimension * 0.42f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        primary.copy(alpha = 0.10f),
                        Color.Transparent
                    ),
                    center = center,
                    radius = radius
                ),
                radius = radius,
                center = center
            )
        }
    }
}