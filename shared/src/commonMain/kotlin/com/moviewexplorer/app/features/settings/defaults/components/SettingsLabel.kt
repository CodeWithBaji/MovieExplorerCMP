package com.moviewexplorer.app.features.settings.defaults.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun SettingsLabel(
    title: String
) {

    val dimens = LocalAppDimens.current

    Text(
        text = title,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = MontserratFontFamily(),
            fontSize = dimens.bodyFont,
            fontWeight = FontWeight.Medium,
            color = AppColors.TextSecondary
        )
    )
}