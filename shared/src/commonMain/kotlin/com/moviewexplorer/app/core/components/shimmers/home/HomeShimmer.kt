package com.moviewexplorer.app.core.components.shimmers.home

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.defaults.MovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvBannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.defaults.tv.TvMovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Composable
fun HomeShimmer(
    isTv: Boolean = false,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val transition = rememberInfiniteTransition(
        label = "HomeShimmer"
    )

    val shimmerProgress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ShimmerProgress"
    )

    val shimmerBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF2A2E37),
            Color(0xFF454B57),
            Color(0xFF2A2E37)
        ),
        startX = shimmerProgress * 1200f - 600f,
        endX = shimmerProgress * 1200f
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.Background),
        userScrollEnabled = false,
        contentPadding = PaddingValues(
            bottom = dimens.sectionSpacing
        )
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        BannerDefaults.height(windowType)
                    )
                    .background(shimmerBrush)
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(
                    dimens.sectionSpacing
                )
            )
        }

        items(3) {

            HomeSectionShimmer(
                brush = shimmerBrush
            )

            Spacer(
                modifier = Modifier.height(
                    dimens.sectionSpacing
                )
            )
        }
    }
}