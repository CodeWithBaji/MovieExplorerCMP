package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.CastCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
 fun CreditsShimmer(
    titleWidth: Dp,
    brush: Brush
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val imageSize = CastCardDefaults.imageSize(windowType)
    val cardWidth = CastCardDefaults.cardWidth(windowType)



    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        DetailTitleShimmer(
            brush = brush,
            width = titleWidth
        )

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            ),
            userScrollEnabled = false
        ) {

            items(8) { index ->

                val nameWidth = when (index % 3) {
                    0 -> 0.85f
                    1 -> 0.70f
                    else -> 0.90f
                }

                val roleWidth = when (index % 3) {
                    0 -> 0.65f
                    1 -> 0.80f
                    else -> 0.55f
                }

                Column(
                    modifier = Modifier.width(cardWidth),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(imageSize)
                            .clip(CircleShape)
                            .background(brush)
                    )

                    SpaceVertical(dimens.itemSpacing)

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .fillMaxWidth(nameWidth)
                            .height(12.dp)
                    )

                    SpaceVertical(dimens.itemSpacing / 2)

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .fillMaxWidth(roleWidth)
                            .height(10.dp)
                    )
                }
            }
        }
    }
}