package com.moviewexplorer.app.core.components.shimmers.listings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Composable
fun ListingMovieRowShimmer(
    columns: Int,
    windowType: WindowType,
    brush: Brush
) {

    val dimens = LocalAppDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPadding
            ),
        horizontalArrangement = Arrangement.spacedBy(
            dimens.cardSpacing
        )
    ) {

        repeat(columns) {

            ListingMovieCardShimmer(
                modifier = Modifier.weight(1f),
                windowType = windowType,
                brush = brush
            )
        }
    }
}