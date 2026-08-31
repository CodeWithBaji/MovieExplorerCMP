package com.moviewexplorer.app.core.designsystem.ui.defaults

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType

@Immutable
object BottomBarDefaults {
    fun bottomBarHeight(windowType: WindowType): Dp =
        when (windowType) {
            WindowType.Compact -> 72.dp
            WindowType.Medium -> 76.dp
            WindowType.Expanded -> 80.dp
        }
}