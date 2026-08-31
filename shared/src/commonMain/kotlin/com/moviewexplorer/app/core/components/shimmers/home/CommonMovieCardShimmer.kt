package com.moviewexplorer.app.core.components.shimmers.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
 fun CommonMovieCardShimmer(
    brush: Brush,
    cardWidth: Dp,
    itemSpacing: Dp,
    cornerMedium: Dp,
    isTv: Boolean
) {

    Column(
        modifier = Modifier.width(cardWidth)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .clip(
                    RoundedCornerShape(cornerMedium)
                )
                .background(brush)
        )

        Spacer(
            modifier = Modifier.height(itemSpacing)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(
                    if (isTv) 16.dp else 13.dp
                )
                .clip(RoundedCornerShape(50))
                .background(brush)
        )

        Spacer(
            modifier = Modifier.height(itemSpacing / 2)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.40f)
                .height(
                    if (isTv) 13.dp else 10.dp
                )
                .clip(RoundedCornerShape(50))
                .background(brush)
        )
    }
}