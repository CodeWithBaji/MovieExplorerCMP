package com.moviewexplorer.app.features.listingScreen

import com.moviewexplorer.app.core.utils.ListingType
import com.moviewexplorer.app.core.utils.MediaType

sealed interface ListingIntent {
    data class FetchListingData(val mediaType: MediaType, val listingType: ListingType) : ListingIntent

    object LoadNextPage : ListingIntent

    data object Retry : ListingIntent
}