package com.moviewexplorer.app.domain.repository

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Movie

interface ListingRepository {
    suspend fun getTrending(
        page: Int = 1,
        mediaType: MediaType
    ): List<Movie>

    suspend fun searchAll(
        page: Int = 1,
        query: String = ""
    ): List<Movie>
}