package com.moviewexplorer.app.features.splash.defaults.components



import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.SplashDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType



@Composable
fun AnimatedGlow(
    modifier: Modifier = Modifier
) {
    val windowType = LocalWindowType.current

    // Resolve theme color before entering Canvas
    val primaryColor = AppColors.Primary

    val transition = rememberInfiniteTransition(label = "glow")

    val glowScale by transition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.04f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowScale"
    )

    val glowAlpha by transition.animateFloat(
        initialValue = 0.10f,
        targetValue = 0.18f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Canvas(
        modifier = modifier.size(
            SplashDefaults.logoGlowSize(windowType) * glowScale
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
                    primaryColor.copy(alpha = glowAlpha),
                    primaryColor.copy(alpha = glowAlpha * 0.45f),
                    primaryColor.copy(alpha = glowAlpha * 0.15f),
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