package com.moviewexplorer.app.features.details.common

import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Credits
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.domain.model.Review
import com.moviewexplorer.app.domain.model.Video

data class DetailsState(

    val isLoading: Boolean = false,

    val banners: List<Banner> = emptyList(),

    val details: Movie? = null,

    val credits: Credits? = null,

    val recommendedMovies: List<Movie> = emptyList(),

    val similarMovies: List<Movie> = emptyList(),

    val videos: List<Video> = emptyList(),

    val reviews: List<Review> = emptyList(),

    val isRefreshing: Boolean = false,

    val error: String? = null
)
