package com.moviewexplorer.app.core.designsystem.ui.responsive.defaults

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun getWindowType(width: Dp): com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType {
    return when {
        width < 700.dp -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact
        width < 1100.dp -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium
        else -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded
    }
}

