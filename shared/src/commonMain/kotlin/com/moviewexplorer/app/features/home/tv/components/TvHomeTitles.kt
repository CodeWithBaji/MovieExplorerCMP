package com.moviewexplorer.app.features.home.tv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens

@Composable
fun TvHomeTitles(
    title: String,
    textSize: TextUnit = LocalTvDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalTvDimens.current.bodyFont
) {

    val dimens = LocalTvDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            fontFamily = MontserratFontFamily(),
            fontSize = textSize,
            fontWeight = FontWeight.Bold,
            color = AppColors.TextPrimary
        )

        Text(
            text = "VIEW ALL",
            fontFamily = MontserratFontFamily(),
            fontSize = viewAllSize,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.Primary
        )
    }
}