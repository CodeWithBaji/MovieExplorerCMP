package com.moviewexplorer.app.features.home.common

sealed interface HomeIntent {

    data object FetchHomeData : HomeIntent
    data object Retry : HomeIntent
}