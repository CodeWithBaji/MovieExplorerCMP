package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun QuickFactsShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current

    Column {

        DetailTitleShimmer(
            brush = brush,
            width = 130.dp
        )

        SpaceVertical(dimens.itemSpacing)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.screenPadding),
            verticalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            repeat(2) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        dimens.cardSpacing
                    )
                ) {

                    repeat(2) {

                        ShimmerBox(
                            brush = brush,
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 160.dp)
                        )
                    }
                }
            }
        }
    }
}

