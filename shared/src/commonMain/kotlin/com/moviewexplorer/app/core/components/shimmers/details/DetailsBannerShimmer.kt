package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BannerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun DetailsBannerShimmer(
    brush: Brush,
    windowType: WindowType
) {

    val dimens = LocalAppDimens.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                BannerDefaults.detailsBannerHeight(windowType)
            )
            .background(Color(0xFF252932))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            AppColors.Background.copy(alpha = 0.15f),
                            AppColors.Background.copy(alpha = 0.45f),
                            AppColors.Background.copy(alpha = 0.75f),
                            AppColors.Background
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(dimens.screenPadding)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.itemSpacing
                )
            ) {

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(82.dp)
                        .height(24.dp)
                )

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(45.dp)
                        .height(16.dp)
                )

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(45.dp)
                        .height(16.dp)
                )
            }

            SpaceVertical(dimens.itemSpacing)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .height(34.dp)
            )

            SpaceVertical(dimens.itemSpacing)

            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.itemSpacing / 2
                )
            ) {

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(105.dp)
                        .height(28.dp)
                )

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(75.dp)
                        .height(28.dp)
                )

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(90.dp)
                        .height(28.dp)
                )
            }

            SpaceVertical(dimens.itemSpacing)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )

            SpaceVertical(6.dp)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth(0.92f)
                    .height(15.dp)
            )

            SpaceVertical(6.dp)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .height(15.dp)
            )

            SpaceVertical(dimens.itemSpacing)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(70.dp)
                        .height(16.dp)
                )

                SpacerHorizontal(dimens.itemSpacing)

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(55.dp)
                        .height(16.dp)
                )
            }

            SpaceVertical(dimens.sectionSpacing / 2)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        BannerDefaults.detailsButtonHeight(windowType)
                    )
            )

            SpaceVertical(dimens.itemSpacing)

            ShimmerBox(
                brush = brush,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        BannerDefaults.detailsButtonHeight(windowType)
                    )
            )
        }
    }
}