package com.moviewexplorer.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.moviewexplorer.app.core.designsystem.theme.AppTheme
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.ResponsiveTheme
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvResponsiveTheme
import com.moviewexplorer.app.core.navigation.AppNavigation
import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode

@Composable
fun App(
    isTv: Boolean
) {

    var themeMode by rememberSaveable {
        mutableStateOf(AppThemeMode.DARK)
    }

    AppTheme(
        themeMode = themeMode
    ) {

        if (isTv) {

            TvResponsiveTheme {
                AppNavigation(isTv = true, themeMode = themeMode, onThemeChange = { themeMode = it })
            }

        } else {

            ResponsiveTheme {
                AppNavigation(isTv = false, themeMode = themeMode, onThemeChange = { themeMode = it })
            }
        }
    }
}