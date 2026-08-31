package com.moviewexplorer.app.core.navigation

import kotlinx.serialization.Serializable


@Serializable
data object SplashRoute

@Serializable
data object HomeRoute

@Serializable
data object SettingsRoute

@Serializable
data class DetailsRoute(
    val movieId: Int,
    val mediaType: String
)

@Serializable
data class ListingRoute(
    val listingType: String
)

@Serializable
data class GalleryRoute(
    val movieId: Int,
    val mediaType: String
)

