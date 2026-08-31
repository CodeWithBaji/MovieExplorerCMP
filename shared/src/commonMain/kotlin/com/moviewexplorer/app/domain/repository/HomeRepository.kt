package com.moviewexplorer.app.domain.repository

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Movie

interface HomeRepository {
    suspend fun discover(
        mediaType: MediaType
    ): List<Movie>



    suspend fun getPopular(
        page: Int,
        mediaType: MediaType
    ): List<Movie>


    suspend fun topRated(
        page: Int = 1,
        mediaType: MediaType
    ): List<Movie>



    suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String
    ): List<Movie>


}