package com.moviewexplorer.app.core.components.shimmers.tv

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvShimmerSection() {

    val dimens = LocalTvDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        Box(
            modifier = Modifier
                .padding(
                    horizontal = dimens.screenPadding
                )
                .width(220.dp)
                .height(28.dp)
                .clip(
                    RoundedCornerShape(
                        dimens.cornerSmall
                    )
                )
                .shimmer()
        )

        SpaceVertical(dimens.itemSpacing)


        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {
            items(6) {

                TvShimmerBox(
                    modifier = Modifier
                        .width(dimens.cardWidth)
                        .aspectRatio(2f / 3f)
                        .clip(
                            RoundedCornerShape(
                                dimens.cornerMedium
                            )
                        )
                )
            }
        }
    }
}