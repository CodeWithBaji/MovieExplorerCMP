package com.moviewexplorer.app.features.home.defaults.components.topbar

import androidx.compose.runtime.Composable
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.LocalWindowType
import com.moviewexplorer.app.core.designsystem.ui.responsive.defaults.WindowType
import com.moviewexplorer.app.core.utils.ListingType

@Composable
fun TopBar(
    elevated: Boolean,
    onListingScreen: (listingType: ListingType) -> Unit,
    onSettingsClick: () -> Unit
) {
    when (LocalWindowType.current) {

        WindowType.Compact -> {
            MobileTopBar(
                elevated = elevated,
                onListingScreen = onListingScreen
            )
        }

        WindowType.Medium,
        WindowType.Expanded -> {
            DesktopTopBar(
                elevated = elevated,
                onListingScreen = onListingScreen,
                onSettingsClick = {
                    onSettingsClick()
                }
            )
        }
    }
}