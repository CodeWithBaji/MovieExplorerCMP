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
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.defaults.MovieCardDefaults
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType

@Composable
 fun MovieCardShimmer(
    brush: Brush
) {
    val dimens = LocalAppDimens.current
    val windowType = LocalWindowType.current

    val cardWidth = MovieCardDefaults.width(windowType)

    Column(
        modifier = Modifier.width(cardWidth)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .clip(
                    RoundedCornerShape(
                        dimens.cornerMedium
                    )
                )
                .background(brush)
        )

        Spacer(
            modifier = Modifier.height(
                dimens.itemSpacing
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(16.dp)
                .clip(
                    RoundedCornerShape(
                        dimens.cornerSmall
                    )
                )
                .background(brush)
        )

        Spacer(
            modifier = Modifier.height(
                dimens.itemSpacing / 2
            )
        )

        Box(
            modifier = Modifier
                .width(cardWidth * 0.35f)
                .height(12.dp)
                .clip(
                    RoundedCornerShape(
                        dimens.cornerSmall
                    )
                )
                .background(brush)
        )
    }
}