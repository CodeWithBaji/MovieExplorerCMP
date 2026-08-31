package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.ReviewCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun ReviewsShimmer(
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

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            ),
            userScrollEnabled = false
        ) {

            items(4) {

                ShimmerBox(
                    brush = brush,
                    modifier = Modifier
                        .width(
                            ReviewCardDefaults.width(windowType)
                        )
                        .height(
                            ReviewCardDefaults.height(windowType)
                        )
                )
            }
        }
    }
}

