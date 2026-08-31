package com.moviewexplorer.app.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors {

//    // Brand
//    val Primary = Color(0xFFB71C1C)
//    val PrimaryLight = Color(0xFFD32F2F)
//    val PrimaryDark = Color(0xFF7F0000)
//
//    // Backgrounds
//    //val Background = Color(0xFF090A0C)
//    val Background = Color(0xFF1C1F26)
//    val BackgroundSecondary = Color(0xFF0E1014)
//
//    // Surfaces
//    val Surface = Color(0xFF14161B)
//    val SurfaceVariant = Color(0xFF1C1F26)
//    val SurfaceElevated = Color(0xFF24272F)
//
//    // Text
//    val TextPrimary = Color(0xFFF5F5F5)
//    val TextSecondary = Color(0xFFB0B3BA)
//    val TextRed = Color(0xFFF6C7C7)
//    val TextTertiary = Color(0xFF777B84)
//    val TextDisabled = Color(0xFF555860)
//
//    // Borders
//    val Border = Color(0xFF2B2E35)
//    val BorderStrong = Color(0xFF41454F)
//
//    // Movie metadata
//    val Rating = Color(0xFFFFC857)
//    val Metadata = Color(0xFFB0B3BA)
//
//    // States
//    val Success = Color(0xFF4CAF78)
//    val Warning = Color(0xFFFFB74D)
//    val Error = Color(0xFFEF5350)
//
//    // Overlay
//    val Scrim = Color.Black.copy(alpha = 0.60f)
//    val ScrimStrong = Color.Black.copy(alpha = 0.82f)
//
//    // Focus - especially useful for TV/Desktop
//    val Focus = Color(0xFFD32F2F)
//    val FocusBorder = Color(0xFFE57373)



        // Brand
        val Primary: Color
            @Composable get() = LocalAppColors.current.primary

        val PrimaryLight: Color
            @Composable get() = LocalAppColors.current.primaryLight

        val PrimaryDark: Color
            @Composable get() = LocalAppColors.current.primaryDark

        // Backgrounds
        val Background: Color
            @Composable get() = LocalAppColors.current.background

        val BackgroundSecondary: Color
            @Composable get() = LocalAppColors.current.backgroundSecondary

        // Surfaces
        val Surface: Color
            @Composable get() = LocalAppColors.current.surface

        val SurfaceVariant: Color
            @Composable get() = LocalAppColors.current.surfaceVariant

        val SurfaceElevated: Color
            @Composable get() = LocalAppColors.current.surfaceElevated

        // Text
        val TextPrimary: Color
            @Composable get() = LocalAppColors.current.textPrimary

        val TextSecondary: Color
            @Composable get() = LocalAppColors.current.textSecondary

        val TextRed: Color
            @Composable get() = LocalAppColors.current.textRed

        val TextTertiary: Color
            @Composable get() = LocalAppColors.current.textTertiary

        val TextDisabled: Color
            @Composable get() = LocalAppColors.current.textDisabled

        // Borders
        val Border: Color
            @Composable get() = LocalAppColors.current.border

        val BorderStrong: Color
            @Composable get() = LocalAppColors.current.borderStrong

        // Movie metadata
        val Rating: Color
            @Composable get() = LocalAppColors.current.rating

        val Metadata: Color
            @Composable get() = LocalAppColors.current.metadata

        // States
        val Success: Color
            @Composable get() = LocalAppColors.current.success

        val Warning: Color
            @Composable get() = LocalAppColors.current.warning

        val Error: Color
            @Composable get() = LocalAppColors.current.error

        // Overlay
        val Scrim: Color
            @Composable get() = LocalAppColors.current.scrim

        val ScrimStrong: Color
            @Composable get() = LocalAppColors.current.scrimStrong

        // Focus
        val Focus: Color
            @Composable get() = LocalAppColors.current.focus

        val FocusBorder: Color
            @Composable get() = LocalAppColors.current.focusBorder

}