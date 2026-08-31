package com.moviewexplorer.app.core.designsystem.ui.defaults.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType

@Immutable
object TvReviewCardDefaults {

    fun width(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 420.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 480.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 540.dp
        }

    fun height(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 340.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 380.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 420.dp
        }

    fun avatarSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 72.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 84.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 96.dp
        }

    fun ratingIconSize(windowType: com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType): Dp =
        when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> 22.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> 26.dp
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> 30.dp
        }
}