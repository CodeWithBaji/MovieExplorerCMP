package com.moviewexplorer.app.features.splash.defaults.components



import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.theme.LocalAppColors


@Composable
fun AnimatedBackground(
    modifier: Modifier = Modifier
) {

    // Resolve theme colors here
    val colors = LocalAppColors.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colors.background,
                        colors.backgroundSecondary,
                        colors.background
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

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        colors.primary.copy(alpha = 0.10f),
                        Color.Transparent
                    ),
                    center = center,
                    radius = size.minDimension * 0.42f
                ),
                radius = size.minDimension * 0.42f,
                center = center
            )
        }
    }
}