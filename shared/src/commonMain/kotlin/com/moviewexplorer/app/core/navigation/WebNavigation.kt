package com.moviewexplorer.app.core.navigation



import androidx.navigation.NavHostController

expect fun setupWebBackNavigation(
    navController: NavHostController
)

expect fun pushWebHistory()

expect fun webBack()