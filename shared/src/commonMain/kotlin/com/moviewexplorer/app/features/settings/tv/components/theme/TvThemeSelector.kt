package com.moviewexplorer.app.features.settings.tv.components.theme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp

import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode

@Composable
fun TvThemeSelector(
    selectedTheme: AppThemeMode,

    systemRequester: FocusRequester,
    lightRequester: FocusRequester,
    darkRequester: FocusRequester,

    upRequester: FocusRequester,
    downRequester: FocusRequester,

    onThemeChange: (AppThemeMode) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        TvThemeOption(
            title = "System",
            icon = Icons.Default.Settings,
            selected = selectedTheme == AppThemeMode.SYSTEM,

            modifier = Modifier
                .weight(1f)
                .focusRequester(systemRequester)
                .focusProperties {
                    up = upRequester
                    right = lightRequester
                    down = downRequester
                },

            onClick = {
                onThemeChange(AppThemeMode.SYSTEM)
            }
        )

        TvThemeOption(
            title = "Light",
            icon = Icons.Default.LightMode,
            selected = selectedTheme == AppThemeMode.LIGHT,

            modifier = Modifier
                .weight(1f)
                .focusRequester(lightRequester)
                .focusProperties {
                    up = upRequester
                    left = systemRequester
                    right = darkRequester
                    down = downRequester
                },

            onClick = {
                onThemeChange(AppThemeMode.LIGHT)
            }
        )

        TvThemeOption(
            title = "Dark",
            icon = Icons.Default.DarkMode,
            selected = selectedTheme == AppThemeMode.DARK,

            modifier = Modifier
                .weight(1f)
                .focusRequester(darkRequester)
                .focusProperties {
                    up = upRequester
                    left = lightRequester
                    down = downRequester
                },

            onClick = {
                onThemeChange(AppThemeMode.DARK)
            }
        )
    }
}