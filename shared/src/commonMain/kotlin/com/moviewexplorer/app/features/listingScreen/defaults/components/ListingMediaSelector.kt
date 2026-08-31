package com.moviewexplorer.app.features.listingScreen.defaults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens
import com.moviewexplorer.app.core.utils.MediaType

@Composable
fun ListingMediaSelector(
    selectedMediaType: MediaType,
    onMediaTypeSelected: (MediaType) -> Unit
) {

    val dimens = LocalAppDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPadding,
                vertical = dimens.itemSpacing
            )
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
            .padding(4.dp)
    ) {

        ListingMediaOption(
            title = "Movies",
            selected = selectedMediaType == MediaType.MOVIE,
            modifier = Modifier.weight(1f),
            onClick = {
                onMediaTypeSelected(MediaType.MOVIE)
            }
        )

        ListingMediaOption(
            title = "TV Shows",
            selected = selectedMediaType == MediaType.TV,
            modifier = Modifier.weight(1f),
            onClick = {
                onMediaTypeSelected(MediaType.TV)
            }
        )
    }
}