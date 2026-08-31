package com.moviewexplorer.app.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.moviewexplorer.app.core.navigation.animation.fadeScaleIn
import com.moviewexplorer.app.core.navigation.animation.fadeScaleOut
import com.moviewexplorer.app.core.navigation.animation.popFadeScaleIn
import com.moviewexplorer.app.core.navigation.animation.popFadeScaleOut
import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.features.details.defaults.DetailsScreen
import com.moviewexplorer.app.features.details.tv.TvDetailsScreen
import com.moviewexplorer.app.features.home.defaults.HomeScreen
import com.moviewexplorer.app.features.home.tv.TvHomeScreen
import com.moviewexplorer.app.features.imageGallery.ImageGallery
import com.moviewexplorer.app.features.listingScreen.defaults.ListingScreen
import com.moviewexplorer.app.features.listingScreen.tv.TvListingScreen
import com.moviewexplorer.app.features.settings.defaults.SettingsScreen
import com.moviewexplorer.app.features.settings.defaults.components.theme.AppThemeMode
import com.moviewexplorer.app.features.settings.tv.TvSettingsScreen
import com.moviewexplorer.app.features.splash.defaults.SplashScreen
import com.moviewexplorer.app.features.splash.tv.TvSplashScreen

@Composable
fun AppNavigation(
    isTv: Boolean = false,
    themeMode: AppThemeMode,
    onThemeChange: (AppThemeMode) -> Unit
) {

    val navController = rememberNavController()


    LaunchedEffect(Unit) {
        setupWebBackNavigation(navController)
    }

    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        composable<SplashRoute> {
            if(isTv){
                TvSplashScreen(
                    onSplashFinished = {
                        navController.navigate(HomeRoute) {
                            popUpTo<SplashRoute> {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }else{
                SplashScreen(
                    onSplashFinished = {
                        navController.navigate(HomeRoute) {
                            popUpTo<SplashRoute> {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }

        }

        composable<HomeRoute> {
            if(isTv){
                TvHomeScreen(
                    onDetailsScreen = { movieId, mediaType ->
                        navController.navigate(
                            DetailsRoute(movieId, mediaType.name)
                        )
                    },
                    onSettingsClick = {
                        navController.navigate(SettingsRoute){
                            launchSingleTop = true
                        }
                    },
                    onListingScreen = {
                        navController.navigate(
                            ListingRoute(it.name)
                        )

                    }
                )
            }else{
                HomeScreen(
                    onDetailsScreen = { movieId, mediaType ->
                        pushWebHistory()
                        navController.navigate(
                            DetailsRoute(movieId, mediaType.name)
                        )
                    },
                    onListingScreen = {
                        pushWebHistory()
                        navController.navigate(
                            ListingRoute( it.name)
                        )
                    },
                    onSettingsClick = {
                        pushWebHistory()
                        navController.navigate(SettingsRoute){
                            launchSingleTop = true
                        }
                    }
                )
            }

        }



        composable<DetailsRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->

            val route = backStackEntry.toRoute<DetailsRoute>()

            val mediaType = MediaType.valueOf(route.mediaType)

            if(isTv){

                TvDetailsScreen(
                    onBackPress = {
                        navController.popBackStack()
                    },
                    movieId = route.movieId,
                    mediaType = mediaType,
                    onViewDetails = {  movieId, mediaType ->

                    },
                    viewAllImages = { movieId, mediaType ->

                    }
                )

            }else{

                DetailsScreen(
                    movieId = route.movieId,
                    mediaType = mediaType,
                    onBackPress = {
                        navController.popBackStack()
                    },
                    viewAllImages = { movieId, mediaType ->

                        pushWebHistory()

                        navController.navigate(
                            GalleryRoute(movieId, mediaType.name)
                        )
                    },
                    onViewDetails = { movieId, mediaType ->

                        pushWebHistory()

                        navController.navigate(
                            DetailsRoute(movieId, mediaType.name)
                        )
                    }
                )

            }




        }

        composable<ListingRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->
            val route = backStackEntry.toRoute<ListingRoute>()

            val listingType = ListingType.valueOf(route.listingType)

            if(isTv){
                TvListingScreen(
                    listingType,
                    onBackPress = {
                        navController.popBackStack()
                    },
                    onDetailsScreen = { id, mediaType ->
                        navController.navigate(
                            DetailsRoute(id, mediaType.name)
                        )
                    }
                )
            }else{
                ListingScreen(
                    listingType,
                    onBackPress = {
                        navController.popBackStack()
                    },
                    onDetailsScreen = { id, mediaType ->
                        navController.navigate(
                            DetailsRoute(id, mediaType.name)
                        )
                    }
                )
            }

        }

        composable<GalleryRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->

            val route = backStackEntry.toRoute<GalleryRoute>()

            val mediaType = MediaType.valueOf(route.mediaType)

            ImageGallery(
                onBackPress = {
                    navController.popBackStack()
                },
                route.movieId,
                mediaType
            )
        }

        composable<SettingsRoute>(
            enterTransition = fadeScaleIn,
            exitTransition = fadeScaleOut,
            popEnterTransition = popFadeScaleIn,
            popExitTransition = popFadeScaleOut
        ) { backStackEntry ->


            if(isTv){
                TvSettingsScreen(
                    onBackPress = {
                        navController.popBackStack()
                    },

                    selectedTheme = themeMode,

                    onThemeChange = onThemeChange
                )
            }else{
                SettingsScreen(
                    onBackPress = {
                        navController.popBackStack()
                    },
                    selectedTheme = themeMode,
                    onThemeChange = onThemeChange
                )
            }

        }
    }
}