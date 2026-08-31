package com.moviewexplorer.app.core.designsystem.ui.responsive.tv

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalTvDimens = staticCompositionLocalOf<com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvDimens> {
    error("No TvDimens provided")
}

val LocalTvWindowType = staticCompositionLocalOf<com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType> {
    error("No TvWindowType provided")
}

@Composable
fun TvResponsiveTheme(
    content: @Composable () -> Unit
) {

    BoxWithConstraints {

        val windowType =
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.getTvWindowType(
                maxWidth
            )

        val dimens = when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Compact -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.CompactTvDimens
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Medium -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.MediumTvDimens
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.TvWindowType.Expanded -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.ExpandedTvDimens
        }

        CompositionLocalProvider(
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvDimens provides dimens,
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.tv.LocalTvWindowType provides windowType
        ) {
            content()
        }
    }
}