package com.moviewexplorer.app.core.designsystem.ui.responsive.defaults

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppDimens = staticCompositionLocalOf<com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.AppDimens> {
    error("No AppDimens provided")
}

val LocalWindowType = staticCompositionLocalOf<com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType> {
    error("No WindowType provided")
}

@Composable
fun ResponsiveTheme(
    content: @Composable () -> Unit
) {

    BoxWithConstraints {

        val windowType =
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.getWindowType(
                maxWidth
            )

        val appDimens = when (windowType) {
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Compact -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.CompactDimens
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Medium -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.MediumDimens
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType.Expanded -> _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.ExpandedDimens
        }

        CompositionLocalProvider(
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalAppDimens provides appDimens,
            _root_ide_package_.com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType provides windowType
        ) {
            content()
        }
    }
}





