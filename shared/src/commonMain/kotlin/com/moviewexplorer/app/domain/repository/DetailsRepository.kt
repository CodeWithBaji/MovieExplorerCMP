package com.moviewexplorer.app.domain.repository

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.model.Banner
import com.moviewexplorer.app.domain.model.Credits
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.domain.model.Review
import com.moviewexplorer.app.domain.model.Video

interface DetailsRepository {
    suspend fun getDetailsBanner(movieId: Int, mediaType: MediaType): List<Banner>
    suspend fun getMovieCastAndCrew(movieId: Int): Credits
    suspend fun getMovieDetails(movieId: Int): Movie
    suspend fun getRecommended(movieId: Int,  mediaType: MediaType): List<Movie>

    suspend fun getSimilar(movieId: Int,  mediaType: MediaType): List<Movie>
    suspend fun getMovieVideos(movieId: Int): List<Video>

    suspend fun getMovieReviews(movieId: Int): List<Review>
}