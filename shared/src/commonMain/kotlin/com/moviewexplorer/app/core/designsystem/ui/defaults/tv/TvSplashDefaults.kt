package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvSplashDefaults {

    fun logoSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 160.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 240.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 320.dp
        }

    fun bottomPadding(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 90.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 120.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 150.dp
        }

    fun loadingWidth(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 320.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 420.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 520.dp
        }

    fun titleFont(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 38.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 46.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 54.sp
        }

    fun subtitleFont(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 18.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 22.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 26.sp
        }

    fun titleLetterSpacing(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 6.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 7.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 8.sp
        }

    fun subtitleLetterSpacing(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): TextUnit =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 4.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 5.sp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 6.sp
        }

    fun backgroundGlowStartRadius(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 450f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 600f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 750f
        }

    fun backgroundGlowEndRadius(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 700f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 900f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 1100f
        }

    fun logoGlowSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 420.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 520.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 620.dp
        }

    fun loadingBarHeight(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 10.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 12.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 14.dp
        }

    fun scannerWidth(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Float =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 100f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 130f
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 160f
        }
}