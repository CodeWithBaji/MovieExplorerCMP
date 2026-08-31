package com.moviewexplorer.app.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.moviewexplorer.app.core.designsystem.theme.AppColorSchemes.DarkAppColors
import com.moviewexplorer.app.core.designsystem.theme.AppColorSchemes.LightAppColors
import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode


@Composable
fun AppTheme(
    themeMode: AppThemeMode,
    content: @Composable () -> Unit
) {

    val colors = when (themeMode) {

        AppThemeMode.DARK -> DarkAppColors

        AppThemeMode.LIGHT -> LightAppColors

        AppThemeMode.SYSTEM -> {
            if (isSystemInDarkTheme()) {
                DarkAppColors
            } else {
                LightAppColors
            }
        }
    }

    CompositionLocalProvider(
        LocalAppColors provides colors
    ) {
        MaterialTheme {
            content()
        }
    }
}