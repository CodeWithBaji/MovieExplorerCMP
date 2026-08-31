package com.moviewexplorer.app.features.listingScreen.defaults.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun ListingMediaOption(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val dimens = LocalAppDimens.current

    val backgroundColor by animateColorAsState(
        targetValue = if (selected) {
            AppColors.Primary
        } else {
            Color.Transparent
        },
        label = "ListingMediaBackground"
    )

    val textColor by animateColorAsState(
        targetValue = if (selected) {
            Color.White
        } else {
            AppColors.TextSecondary
        },
        label = "ListingMediaText"
    )

    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    dimens.cornerSmall
                )
            )
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(
                vertical = dimens.itemSpacing
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            fontWeight = FontWeight.SemiBold,
            color = textColor
        )
    }
}