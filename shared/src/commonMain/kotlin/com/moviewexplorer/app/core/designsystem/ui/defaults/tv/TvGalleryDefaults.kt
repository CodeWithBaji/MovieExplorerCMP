package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvGalleryDefaults {

    fun columns(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Int =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 4
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 5
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 7
        }

    fun imageHeight(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 220.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 260.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 300.dp
        }
}