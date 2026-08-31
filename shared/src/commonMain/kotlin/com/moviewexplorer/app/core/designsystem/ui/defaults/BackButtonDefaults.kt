package com.moviewexplorer.app.core.designsystem.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Immutable
object BackButtonDefaults {

    fun circleSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 45.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium,
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 60.dp
        }

    fun arrowSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> 25.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium,
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> 30.dp
        }
}