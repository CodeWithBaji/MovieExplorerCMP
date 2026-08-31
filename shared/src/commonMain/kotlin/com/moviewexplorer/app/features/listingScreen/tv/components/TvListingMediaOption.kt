package com.moviewexplorer.app.features.listingScreen.tv.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvListingMediaOption(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val dimens = LocalTvDimens.current

    Row(
        modifier = modifier
            .focusable()
            .onPreviewKeyEvent { event ->

                if (event.type != KeyEventType.KeyDown) {
                    return@onPreviewKeyEvent false
                }

                when (event.key) {

                    Key.Enter,
                    Key.NumPadEnter,
                    Key.DirectionCenter -> {

                        onClick()
                        true
                    }

                    else -> false
                }
            }
            .clickable {
                onClick()
            }
            .clip(
                RoundedCornerShape(
                    dimens.cornerMedium
                )
            )
            .background(
                if (selected) {
                    AppColors.Primary
                } else {
                    Color.Transparent
                }
            )
            .padding(
                vertical = dimens.itemSpacing,
                horizontal = dimens.screenPadding
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,

            color = if (selected) {
                Color.White
            } else {
                AppColors.TextSecondary
            },

            fontFamily = MontserratFontFamily(),

            fontWeight = if (selected) {
                FontWeight.SemiBold
            } else {
                FontWeight.Medium
            },

            maxLines = 1
        )
    }
}