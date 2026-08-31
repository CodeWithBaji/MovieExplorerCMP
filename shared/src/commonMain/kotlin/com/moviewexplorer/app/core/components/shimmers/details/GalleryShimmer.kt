package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.GalleryDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun GalleryShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column {

        DetailTitleShimmer(
            brush = brush,
            width = 100.dp
        )

        SpaceVertical(dimens.itemSpacing)

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.screenPadding)
        ) {

            val columns = GalleryDefaults.columns(windowType)

            val itemWidth =
                (maxWidth - dimens.cardSpacing * (columns - 1)) / columns

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = columns,
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.cardSpacing
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimens.cardSpacing
                )
            ) {

                repeat(
                    if (windowType == WindowType.Compact) 6 else 12
                ) {

                    ShimmerBox(
                        brush = brush,
                        modifier = Modifier
                            .width(itemWidth)
                            .height(
                                GalleryDefaults.imageHeight(windowType)
                            )
                    )
                }
            }
        }
    }
}

