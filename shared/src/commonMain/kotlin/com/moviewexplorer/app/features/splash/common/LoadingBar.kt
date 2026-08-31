package com.moviewexplorer.app.features.splash.common



import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.LocalAppColors


@Composable
fun LoadingBar(
    modifier: Modifier = Modifier
) {
    val transition = rememberInfiniteTransition(label = "loading")

    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2400,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    )

    // Resolve theme colors here, inside @Composable
    val colors = LocalAppColors.current

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(3.dp)
    ) {

        val radius = size.height / 2

        drawRoundRect(
            color = colors.surfaceElevated,
            cornerRadius = CornerRadius(radius, radius)
        )

        drawRoundRect(
            color = colors.primary,
            size = Size(
                width = size.width * progress,
                height = size.height
            ),
            cornerRadius = CornerRadius(radius, radius)
        )
    }
}