package com.moviewexplorer.app.core.designsystem.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Immutable
object TrailerDefaults {

    fun thumbnailHeight(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 200.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 280.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 360.dp
        }

    fun playButtonSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 50.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 70.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 90.dp
        }

    fun playIconSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 28.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 32.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 36.dp
        }

    fun contentMaxWidth(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> Dp.Unspecified
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 900.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 1100.dp
        }

    fun elevation(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 4.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 6.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 8.dp
        }
}