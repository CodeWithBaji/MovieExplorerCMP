package com.moviewexplorer.app.core.components.shimmers.listings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ListingMediaSelectorShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPadding,
                vertical = dimens.itemSpacing
            )
            .height(48.dp)
            .clip(
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .background(
                AppColors.Surface
            )
            .border(
                1.dp,
                AppColors.Border.copy(alpha = 0.5f),
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            dimens.cornerSmall
                        )
                    )
                    .background(brush)
            )

            SpacerHorizontal(4.dp)

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            dimens.cornerSmall
                        )
                    )
                    .background(
                        Color(0xFF202226)
                    )
            )
        }
    }
}