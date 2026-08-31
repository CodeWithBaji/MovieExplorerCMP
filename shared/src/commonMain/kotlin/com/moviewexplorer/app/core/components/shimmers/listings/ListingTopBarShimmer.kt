package com.moviewexplorer.app.core.components.shimmers.listings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.defaults.BackButtonDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
fun ListingTopBarShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = AppColors.Background
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.toolbarHeight)
                .padding(
                    horizontal = dimens.screenPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Back button
            Box(
                modifier = Modifier
                    .size(
                        BackButtonDefaults.circleSize(
                            windowType
                        )
                    )
                    .clip(CircleShape)
                    .background(brush)
            )

            SpacerHorizontal(
                dimens.itemSpacing
            )

            // Title / Search bar
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.searchBarHeight)
                    .clip(
                        RoundedCornerShape(50)
                    )
                    .background(brush)
            )
        }
    }
}