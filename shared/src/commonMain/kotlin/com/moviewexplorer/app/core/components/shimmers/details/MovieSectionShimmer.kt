package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.MovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun MovieSectionShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column {

        DetailTitleShimmer(
            brush = brush,
            width = 160.dp
        )

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            ),
            userScrollEnabled = false
        ) {

            items(10) {

                Column(
                    modifier = Modifier.width(
                        MovieCardDefaults.width(windowType)
                    )
                ) {

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(2f / 3f)
                    )

                    SpaceVertical(dimens.itemSpacing)

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(12.dp)
                    )

                    SpaceVertical(dimens.itemSpacing / 2)

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .width(50.dp)
                            .height(10.dp)
                    )
                }
            }
        }
    }
}

