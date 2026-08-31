package com.moviewexplorer.app.core.designsystem.theme

import androidx.compose.ui.graphics.Color

object AppColorSchemes {

    val DarkAppColors = AppColorScheme(

        primary = Color(0xFFB71C1C),
        primaryLight = Color(0xFFD32F2F),
        primaryDark = Color(0xFF7F0000),

        background = Color(0xFF1C1F26),
        backgroundSecondary = Color(0xFF0E1014),

        surface = Color(0xFF14161B),
        surfaceVariant = Color(0xFF1C1F26),
        surfaceElevated = Color(0xFF24272F),

        textPrimary = Color(0xFFF5F5F5),
        textSecondary = Color(0xFFB0B3BA),
        textRed = Color(0xFFF6C7C7),
        textTertiary = Color(0xFF777B84),
        textDisabled = Color(0xFF555860),

        border = Color(0xFF2B2E35),
        borderStrong = Color(0xFF41454F),

        rating = Color(0xFFFFC857),
        metadata = Color(0xFFB0B3BA),

        success = Color(0xFF4CAF78),
        warning = Color(0xFFFFB74D),
        error = Color(0xFFEF5350),

        scrim = Color.Black.copy(alpha = 0.60f),
        scrimStrong = Color.Black.copy(alpha = 0.82f),

        focus = Color(0xFFD32F2F),
        focusBorder = Color(0xFFE57373)
    )

    val LightAppColors = AppColorScheme(

        primary = Color(0xFFB71C1C),
        primaryLight = Color(0xFFD32F2F),
        primaryDark = Color(0xFF7F0000),

        background = Color(0xFFF7F7F8),
        backgroundSecondary = Color(0xFFEDEEF0),

        surface = Color.White,
        surfaceVariant = Color(0xFFF1F2F4),
        surfaceElevated = Color.White,

        textPrimary = Color(0xFF17181A),
        textSecondary = Color(0xFF5F6368),
        textRed = Color(0xFF8B1A1A),
        textTertiary = Color(0xFF777B84),
        textDisabled = Color(0xFFAAADB2),

        border = Color(0xFFD9DBDF),
        borderStrong = Color(0xFFB8BBC1),

        rating = Color(0xFFE09B00),
        metadata = Color(0xFF5F6368),

        success = Color(0xFF2E7D5B),
        warning = Color(0xFFB86B00),
        error = Color(0xFFD32F2F),

        scrim = Color.Black.copy(alpha = 0.32f),
        scrimStrong = Color.Black.copy(alpha = 0.55f),

        focus = Color(0xFFD32F2F),
        focusBorder = Color(0xFFB71C1C)
    )
}