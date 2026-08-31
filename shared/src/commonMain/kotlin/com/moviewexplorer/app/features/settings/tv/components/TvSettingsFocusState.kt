package com.moviewexplorer.app.features.settings.tv.components

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusRequester

@Stable
class TvSettingsFocusState {

    val back = FocusRequester()

    // Appearance
    val systemTheme = FocusRequester()
    val lightTheme = FocusRequester()
    val darkTheme = FocusRequester()

    // Preferences
    val defaultContent = FocusRequester()
    val clearSearchHistory = FocusRequester()

    // Storage
    val clearImageCache = FocusRequester()

    // About
    val about = FocusRequester()
    val licenses = FocusRequester()
    val tmdbAttribution = FocusRequester()
}