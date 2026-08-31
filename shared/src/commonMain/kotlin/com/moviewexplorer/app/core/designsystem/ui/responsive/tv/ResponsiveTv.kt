package com.moviewexplorer.app.core.designsystem.ui.responsive.tv

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun getTvWindowType(width: Dp): com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType {
    return when {
        width < 1400.dp -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact      // 720p
        width < 2600.dp -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium       // 1080p
        else -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded                // 4K
    }
}