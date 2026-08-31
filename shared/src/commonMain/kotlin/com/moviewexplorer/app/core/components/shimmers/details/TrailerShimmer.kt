package com.moviewexplorer.app.core.components.shimmers.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.defaults.TrailerDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun TrailerShimmer(
    brush: Brush
) {

    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    Column {

        DetailTitleShimmer(
            brush = brush,
            width = 95.dp
        )

        SpaceVertical(dimens.itemSpacing)

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            val modifier = if (windowType == WindowType.Compact) {
                Modifier.fillMaxWidth()
            } else {
                Modifier
                    .widthIn(
                        max = TrailerDefaults.contentMaxWidth(windowType)
                    )
                    .fillMaxWidth()
            }

            Box(
                modifier = modifier
                    .padding(horizontal = dimens.screenPadding)
                    .aspectRatio(16f / 9f)
                    .clip(
                        RoundedCornerShape(
                            dimens.cornerLarge
                        )
                    )
                    .background(brush)
            )
        }
    }
}