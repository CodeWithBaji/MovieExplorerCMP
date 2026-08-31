package com.moviewexplorer.app.core.components.shimmers.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
 fun CommonBannerShimmer(
    brush: Brush,
    bannerHeight: Dp,
    screenPadding: Dp,
    sectionSpacing: Dp,
    itemSpacing: Dp,
    cornerMedium: Dp,
    isTv: Boolean
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(bannerHeight)
            .background(brush)
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(
                    if (isTv) 0.45f else 1f
                )
                .padding(
                    start = screenPadding,
                    end = screenPadding,
                    bottom = sectionSpacing
                )
        ) {

            Box(
                modifier = Modifier
                    .width(if (isTv) 100.dp else 75.dp)
                    .height(if (isTv) 24.dp else 18.dp)
                    .clip(RoundedCornerShape(cornerMedium))
                    .background(brush)
            )

            Spacer(
                modifier = Modifier.height(itemSpacing)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(
                        if (isTv) 0.75f else 0.65f
                    )
                    .height(
                        if (isTv) 42.dp else 32.dp
                    )
                    .clip(RoundedCornerShape(cornerMedium))
                    .background(brush)
            )

            Spacer(
                modifier = Modifier.height(itemSpacing)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    itemSpacing / 2
                )
            ) {

                repeat(3) {

                    Box(
                        modifier = Modifier
                            .width(
                                if (isTv) 80.dp else 60.dp
                            )
                            .height(
                                if (isTv) 26.dp else 20.dp
                            )
                            .clip(RoundedCornerShape(50))
                            .background(brush)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(itemSpacing)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .height(if (isTv) 16.dp else 13.dp)
                    .clip(RoundedCornerShape(50))
                    .background(brush)
            )

            Spacer(
                modifier = Modifier.height(itemSpacing / 2)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(if (isTv) 16.dp else 13.dp)
                    .clip(RoundedCornerShape(50))
                    .background(brush)
            )

            Spacer(
                modifier = Modifier.height(sectionSpacing / 2)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    itemSpacing
                )
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(
                            if (isTv) 52.dp else 46.dp
                        )
                        .clip(
                            RoundedCornerShape(cornerMedium)
                        )
                        .background(brush)
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(
                            if (isTv) 52.dp else 46.dp
                        )
                        .clip(
                            RoundedCornerShape(cornerMedium)
                        )
                        .background(brush)
                )
            }
        }
    }
}