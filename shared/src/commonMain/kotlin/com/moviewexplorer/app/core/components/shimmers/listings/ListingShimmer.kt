package com.moviewexplorer.app.core.components.shimmers.listings

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
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun ListingShimmer(
    columns: Int
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val shimmerBrush = rememberShimmerBrush()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background),
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {



        stickyHeader {

            ListingTopBarShimmer(
                brush = shimmerBrush
            )
        }



        item {

            ListingMediaSelectorShimmer(
                brush = shimmerBrush
            )
        }



        items(4) {

            ListingMovieRowShimmer(
                columns = columns,
                windowType = windowType,
                brush = shimmerBrush
            )

            SpaceVertical(
                dimens.sectionSpacing
            )
        }
    }
}

@Composable
private fun rememberShimmerBrush(): Brush {

    val transition = rememberInfiniteTransition(
        label = "ListingShimmer"
    )

    val translateX by transition.animateFloat(
        initialValue = -600f,
        targetValue = 1200f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ListingShimmerTranslate"
    )

    return Brush.linearGradient(
        colors = listOf(
            Color(0xFF202226),
            Color(0xFF30343A),
            Color(0xFF202226)
        ),
        start = Offset(translateX, 0f),
        end = Offset(
            translateX + 500f,
            500f
        )
    )
}

