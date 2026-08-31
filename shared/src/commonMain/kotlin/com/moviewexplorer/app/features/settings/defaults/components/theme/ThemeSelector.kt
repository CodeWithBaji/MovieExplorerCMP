package com.moviewexplorer.app.features.settings.defaults.components.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens

    @Composable
    fun ThemeSelector(
        selectedTheme: AppThemeMode,
        onThemeChange: (AppThemeMode) -> Unit
    ) {

        val dimens = LocalAppDimens.current

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            ThemeOption(
                title = "System",
                icon = Icons.Default.Settings,
                selected = selectedTheme == AppThemeMode.SYSTEM,
                modifier = Modifier.weight(1f)
            ) {
                onThemeChange(AppThemeMode.SYSTEM)
            }

            ThemeOption(
                title = "Light",
                icon = Icons.Default.LightMode,
                selected = selectedTheme == AppThemeMode.LIGHT,
                modifier = Modifier.weight(1f)
            ) {
                onThemeChange(AppThemeMode.LIGHT)
            }

            ThemeOption(
                title = "Dark",
                icon = Icons.Default.DarkMode,
                selected = selectedTheme == AppThemeMode.DARK,
                modifier = Modifier.weight(1f)
            ) {
                onThemeChange(AppThemeMode.DARK)
            }
        }
    }