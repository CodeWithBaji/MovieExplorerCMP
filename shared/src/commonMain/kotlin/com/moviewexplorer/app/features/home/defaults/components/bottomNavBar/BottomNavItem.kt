package com.moviewexplorer.app.features.home.defaults.components.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector
) {

    data object Home : BottomNavItem(
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Search : BottomNavItem(
        title = "Search",
        icon = Icons.Default.Search
    )

    data object Watchlist : BottomNavItem(
        title = "Watchlist",
        icon = Icons.Outlined.Bookmark
    )

    data object Settings : BottomNavItem(
        title = "Settings",
        icon = Icons.Default.Settings
    )
}