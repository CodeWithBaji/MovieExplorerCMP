package com.moviewexplorer.app.core.designsystem.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Immutable
object SplashDefaults {

    fun logoSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 160.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 220.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 280.dp
        }

    fun bottomPadding(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 60.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 80.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 100.dp
        }

    fun loadingWidth(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> Dp.Unspecified
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 320.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 420.dp
        }

    fun titleFont(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): TextUnit =
        when (windowType) {
//            WindowType.Compact -> 24.sp
//            WindowType.Medium -> 30.sp
//            WindowType.Expanded -> 36.sp
            WindowType.Compact -> 40.sp
            WindowType.Medium -> 48.sp
            WindowType.Expanded -> 58.sp
        }

    fun subtitleFont(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 12.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 14.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 16.sp
        }

    fun titleLetterSpacing(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 4.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 5.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 6.sp
        }

    fun subtitleLetterSpacing(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 3.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 3.5.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 4.sp
        }

    fun backgroundGlowStartRadius(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 250f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 350f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 450f
        }

    fun backgroundGlowEndRadius(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 420f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 550f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 700f
        }

    fun logoGlowSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 260.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 340.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 420.dp
        }

    fun loadingBarHeight(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 8.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 10.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 12.dp
        }

    fun scannerWidth(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 70f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 90f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 110f
        }

    
}