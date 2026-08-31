package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.domain.model.Movie

@Composable
fun BannerSlider(
    banners: List<Movie>,
    currentIndex: Int,
    modifier: Modifier = Modifier,
    onDetailsScreen: (id: Int) -> Unit
) {

    if (banners.isEmpty()) return

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val safeIndex = currentIndex.coerceIn(
        0,
        banners.lastIndex
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(BannerDefaults.height(windowType))
    ) {

        Crossfade(
            targetState = safeIndex,
            animationSpec = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing
            ),
            label = "BannerAnimation",
            modifier = Modifier.fillMaxSize()
        ) { index ->

            HomeBanner(
                movie = banners[index],
                onDetailsScreen = onDetailsScreen
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = dimens.itemSpacing / 2),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            repeat(banners.size) { index ->

                val selected = index == safeIndex

                val width by animateDpAsState(
                    targetValue = if (selected) 28.dp else 6.dp,
                    animationSpec = tween(
                        durationMillis = 350,
                        easing = FastOutSlowInEasing
                    ),
                    label = "IndicatorWidth"
                )

                val color by animateColorAsState(
                    targetValue = if (selected) {
                        AppColors.Primary
                    } else {
                        Color.White.copy(alpha = 0.30f)
                    },
                    animationSpec = tween(350),
                    label = "IndicatorColor"
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .width(width)
                        .height(5.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color)
                )
            }
        }
    }
}