package com.moviewexplorer.app.features.settings.defaults.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.moviewexplorer.app.core.components.SpacerHorizontal
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.theme.MontserratFontFamily
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun SettingsTopBar() {

    val dimens = LocalAppDimens.current

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = AppColors.Background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.toolbarHeight)
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = AppColors.TextPrimary
            )

            SpacerHorizontal(dimens.itemSpacing)

            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = MontserratFontFamily(),
                    fontSize = dimens.sectionTitleFont,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.TextPrimary
                )
            )
        }
    }
}