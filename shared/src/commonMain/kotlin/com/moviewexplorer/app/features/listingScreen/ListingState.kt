package com.moviewexplorer.app.features.listingScreen

import com.moviewexplorer.app.domain.model.Movie

data class ListingState(

    val isLoading: Boolean = false,

    val query: String = "",

    val results: List<Movie> = emptyList(),


    val isLoadingMore: Boolean = false,

    val currentPage: Int = 1,

    val endReached: Boolean = false,

    val isRefreshing: Boolean = false,

    val error: String? = null

)