package com.moviewexplorer.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.moviewexplorer.app.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "MovieExplorer",
    ) {
        App(false)
    }
}