package com.moviewexplorer.app.features.listingScreen.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.components.SpaceVertical
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun NoSearchResult(
    query: String,
    modifier: Modifier = Modifier
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimens.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.SearchOff,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = AppColors.TextSecondary
        )

        SpaceVertical(dimens.sectionSpacing)

        Text(
            text = "No results found",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.sectionTitleFont,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.TextPrimary
        )

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = "We couldn't find anything for",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            color = AppColors.TextSecondary
        )

        SpaceVertical(dimens.itemSpacing / 2)

        Text(
            text = "\"$query\"",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.Primary
        )

        SpaceVertical(dimens.itemSpacing)

        Text(
            text = "Try a different keyword.",
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.captionFont,
            color = AppColors.TextSecondary
        )
    }
}