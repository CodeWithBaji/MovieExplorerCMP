package com.moviewexplorer.app.features.home.defaults.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun HomeTitles(
    title: String,
    textSize: TextUnit = LocalAppDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalAppDimens.current.bodyFont,
    onViewAll: () -> Unit = {}
) {

    val dimens = LocalAppDimens.current
    val montserrat = MontserratFontFamily()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = montserrat,
                fontSize = textSize,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.TextPrimary
            )
        )

        Text(
            text = "View All",
            modifier = Modifier.clickable {
                onViewAll()
            },
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = montserrat,
                fontSize = viewAllSize,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.PrimaryLight
            )
        )
    }
}