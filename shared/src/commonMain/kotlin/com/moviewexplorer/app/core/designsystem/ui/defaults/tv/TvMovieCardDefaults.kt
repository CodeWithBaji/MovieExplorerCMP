package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvMovieCardDefaults {

    fun width(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 160.dp
            TvWindowType.Medium -> 190.dp
            TvWindowType.Expanded -> 220.dp
        }

    fun height(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 240.dp
            TvWindowType.Medium -> 285.dp
            TvWindowType.Expanded -> 330.dp
        }
}