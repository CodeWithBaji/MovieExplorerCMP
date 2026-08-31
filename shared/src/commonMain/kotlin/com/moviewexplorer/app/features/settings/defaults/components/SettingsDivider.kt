package com.moviewexplorer.app.features.settings.defaults.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.theme.AppColors
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

@Composable
fun SettingsDivider() {

    HorizontalDivider(
        modifier = Modifier.padding(
            horizontal = LocalAppDimens.current.itemSpacing
        ),
        color = AppColors.SurfaceVariant
    )
}