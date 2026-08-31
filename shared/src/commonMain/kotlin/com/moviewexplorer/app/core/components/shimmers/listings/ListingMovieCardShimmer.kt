package com.moviewexplorer.app.core.components.shimmers.listings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun ListingMovieCardShimmer(
    modifier: Modifier = Modifier,
    windowType: WindowType,
    brush: Brush
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = modifier
    ) {

        // Poster
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

        SpaceVertical(
            dimens.itemSpacing
        )

        // Movie title
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(
                    dimens.bodyFont.value.dp * 1.2f
                )
                .clip(
                    RoundedCornerShape(4.dp)
                )
                .background(brush)
        )

        SpaceVertical(
            dimens.itemSpacing / 2
        )

        // Year
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f)
                .height(
                    dimens.captionFont.value.dp * 1.2f
                )
                .clip(
                    RoundedCornerShape(4.dp)
                )
                .background(
                    Color(0xFF25282D)
                )
        )
    }
}