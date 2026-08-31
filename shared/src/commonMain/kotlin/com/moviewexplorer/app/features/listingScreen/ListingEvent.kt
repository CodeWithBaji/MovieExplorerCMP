package com.moviewexplorer.app.features.listingScreen

sealed interface ListingEvent {

    data class OnSearchQueryChanged(
        val query: String
    ) : ListingEvent
}