package com.moviewexplorer.app.features.home.tv.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens


import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily

@Composable
fun TvGenreItem(
    genre: String
) {

    val dimens = LocalTvDimens.current

    val shape = RoundedCornerShape(
        dimens.cornerMedium
    )

    Column(
        modifier = Modifier
            .background(
                color = AppColors.Surface,
                shape = shape
            )
            .border(
                border = BorderStroke(
                    width = 0.5.dp,
                    color = AppColors.BorderStrong
                ),
                shape = shape
            )
            .padding(
                horizontal = dimens.itemSpacing,
                vertical = 5.dp
            )
    ) {

        Text(
            text = genre,
            color = AppColors.TextSecondary,
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.captionFont,
            fontWeight = FontWeight.Medium
        )
    }
}