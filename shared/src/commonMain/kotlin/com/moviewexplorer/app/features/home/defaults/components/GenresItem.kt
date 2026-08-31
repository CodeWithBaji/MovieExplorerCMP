package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun GenreItem(genre: String) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier
            .background(
                AppColors.Surface.copy(alpha = 0.90f),
                shape = RoundedCornerShape(dimens.cornerSmall)
            )
            .border(
                BorderStroke(0.5.dp, Color.LightGray),
                shape = RoundedCornerShape(dimens.cornerSmall)
            )
            .padding(
                horizontal = dimens.itemSpacing,
                vertical = 3.dp
            )
    ) {

        Text(
            text = genre,
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = MontserratFontFamily(),
                fontSize = dimens.captionFont,
                fontWeight = FontWeight.Medium,
                color = AppColors.TextRed
            )
        )
    }
}