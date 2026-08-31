package com.moviewexplorer.app.core.designsystem.theme

import androidx.compose.ui.graphics.Color

data class AppColorScheme(
    val primary: Color,
    val primaryLight: Color,
    val primaryDark: Color,

    val background: Color,
    val backgroundSecondary: Color,

    val surface: Color,
    val surfaceVariant: Color,
    val surfaceElevated: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textRed: Color,
    val textTertiary: Color,
    val textDisabled: Color,

    val border: Color,
    val borderStrong: Color,

    val rating: Color,
    val metadata: Color,

    val success: Color,
    val warning: Color,
    val error: Color,

    val scrim: Color,
    val scrimStrong: Color,

    val focus: Color,
    val focusBorder: Color
)