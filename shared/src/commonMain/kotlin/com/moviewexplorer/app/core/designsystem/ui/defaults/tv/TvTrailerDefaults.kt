package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvTrailerDefaults {

    fun thumbnailHeight(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 320.dp
            TvWindowType.Medium -> 420.dp
            TvWindowType.Expanded -> 520.dp
        }

    fun playButtonSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 72.dp
            TvWindowType.Medium -> 88.dp
            TvWindowType.Expanded -> 104.dp
        }

    fun playIconSize(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 36.dp
            TvWindowType.Medium -> 44.dp
            TvWindowType.Expanded -> 52.dp
        }

    fun contentMaxWidth(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 1100.dp
            TvWindowType.Medium -> 1300.dp
            TvWindowType.Expanded -> 1500.dp
        }

    fun elevation(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 8.dp
            TvWindowType.Medium -> 10.dp
            TvWindowType.Expanded -> 12.dp
        }



    fun cardCornerRadius(windowType: TvWindowType): Dp =
        when (windowType) {
            TvWindowType.Compact -> 14.dp
            TvWindowType.Medium -> 18.dp
            TvWindowType.Expanded -> 22.dp
        }
}