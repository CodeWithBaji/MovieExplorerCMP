package com.moviewexplorer.app.core.designsystem.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Immutable
object GalleryDefaults {

    fun columns(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Int =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 3
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 4
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 6
        }

    fun imageHeight(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 150.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> 180.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 200.dp
        }
}