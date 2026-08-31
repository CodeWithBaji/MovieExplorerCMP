package com.moviewexplorer.app.core.navigation

import androidx.navigation.NavHostController

import kotlinx.browser.window


actual fun pushWebHistory() {
    window.history.pushState(
        null,
        "",
        window.location.href
    )
}

actual fun webBack() {
    window.history.back()
}

actual fun setupWebBackNavigation(
    navController: NavHostController
) {
    // Create the initial browser history entry
    window.history.replaceState(
        null,
        "",
        window.location.href
    )

    window.onpopstate = {
        navController.popBackStack()
    }
}