package com.moviewexplorer.app.data.remote


import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.data.dto.details.banner.BannersResponseDto
import com.moviewexplorer.app.data.dto.details.castAndCrew.CastAndCrewResponseDto
import com.moviewexplorer.app.data.dto.details.movieDetails.DetailsResponseDto
import com.moviewexplorer.app.data.dto.details.reviews.ReviewsResponseDto
import com.moviewexplorer.app.data.dto.details.trailer.TrailerResponseDto
import com.moviewexplorer.app.data.dto.movieDto.MoviesResponseDto
import com.moviewexplorer.app.data.dto.tvDto.TvResponseDto

interface MovieApiService {

    suspend fun discoverMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun discoverTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun popularMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun popularTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun topRatedMovies(
        language : String = "en-US",
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto





    suspend fun topRatedTv(
        language : String = "en-US",
        page: Int = 1
    ):  TvResponseDto

    suspend fun getMovieBanners(
        movieId: Int
    ):  BannersResponseDto

    suspend fun getTvBanners(
        seriesId: Int
    ):  BannersResponseDto

    suspend fun getMovieDetails(
        movieId: Int
    ):  DetailsResponseDto

    suspend fun getMovieCredits(
        movieId: Int
    ):  CastAndCrewResponseDto

    suspend fun getRecommendMovies(
        movieId: Int
    ):  MoviesResponseDto

    suspend fun getRecommendTv(
        movieId: Int
    ):  MoviesResponseDto



    suspend fun getSimilarMovies(
        movieId: Int
    ):  MoviesResponseDto

    suspend fun getSimilarTv(
        seriesId: Int
    ):  MoviesResponseDto

    suspend fun getMovieVideo(
        movieId: Int
    ):  TrailerResponseDto

    suspend fun getMovieReviews(
        movieId: Int
    ):  ReviewsResponseDto

    suspend fun getNowPlayingMovie(
        minDate: String,
        maxDate: String,
        page: Int = 1
    ):  MoviesResponseDto

    suspend fun getTrendingMovies(
        page: Int = 1,
        mediaType: MediaType
    ):  MoviesResponseDto

    suspend fun getTrendingTv(
        page: Int = 1,
        mediaType: MediaType
    ): TvResponseDto

    suspend fun searchAll(
        page: Int = 1,
       query: String=""
    ): MoviesResponseDto
}