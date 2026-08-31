package com.moviewexplorer.app.core.utils


import androidx.compose.ui.focus.FocusRequester

fun FocusRequester.safeRequestFocus(): Boolean {
    return try {
        requestFocus()
        true
    } catch (e: IllegalStateException) {
        false
    }
}