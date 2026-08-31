package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvBackButtonDefaults {

//    fun circleSize(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 64.dp
//            TvWindowType.Medium -> 72.dp
//            TvWindowType.Expanded -> 80.dp
//        }

    fun circleSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 48.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 56.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 64.dp
        }

//    fun arrowSize(windowType: TvWindowType): Dp =
//        when (windowType) {
//            TvWindowType.Compact -> 32.dp
//            TvWindowType.Medium -> 36.dp
//            TvWindowType.Expanded -> 40.dp
//        }

    fun arrowSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 22.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 26.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 30.dp
        }
}