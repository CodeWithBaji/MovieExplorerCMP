package com.moviewexplorer.app.features.splash.tv.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvSplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType



@Composable
fun TvAnimatedGlow(
    modifier: Modifier = Modifier
) {
    val windowType = LocalTvWindowType.current

    // Resolve the theme color in Composable scope
    val primaryColor = AppColors.Primary

    Canvas(
        modifier = modifier.size(
            TvSplashDefaults.logoGlowSize(windowType)
        )
    ) {

        val center = Offset(
            size.width / 2f,
            size.height / 2f
        )

        val radius = size.minDimension * 0.42f

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    primaryColor.copy(alpha = 0.18f),
                    primaryColor.copy(alpha = 0.08f),
                    primaryColor.copy(alpha = 0.03f),
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