package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun DetailsShimmer(
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val transition = rememberInfiniteTransition(
        label = "DetailsShimmer"
    )

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1200f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "DetailsShimmerTranslate"
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF30343D),
            Color(0xFF505660),
            Color(0xFF30343D)
        ),
        start = Offset(
            translateAnimation - 400f,
            translateAnimation - 400f
        ),
        end = Offset(
            translateAnimation,
            translateAnimation
        )
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.Background),
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {

        item {
            DetailsBannerShimmer(
                brush = brush,
                windowType = windowType
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            CreditsShimmer(
                titleWidth = 70.dp,
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            CreditsShimmer(
                titleWidth = 75.dp,
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            TrailerShimmer(
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            QuickFactsShimmer(
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            ReviewsShimmer(
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            GalleryShimmer(
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            MovieSectionShimmer(
                brush = brush
            )
        }

        item {
            SpaceVertical(dimens.sectionSpacing)
        }

        item {
            MovieSectionShimmer(
                brush = brush
            )
        }
    }
}

