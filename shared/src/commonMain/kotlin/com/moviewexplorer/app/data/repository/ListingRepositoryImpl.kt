package com.moviewexplorer.app.data.repository

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.data.mapper.toDomain
import com.moviewexplorer.app.data.mapper.toTvDomain
import com.moviewexplorer.app.data.remote.MovieApiService
import com.moviewexplorer.app.domain.model.Movie
import com.moviewexplorer.app.domain.repository.ListingRepository

class ListingRepositoryImpl(
    private val api: MovieApiService
) : ListingRepository {

    override suspend fun getTrending(
        page: Int,
        mediaType: MediaType
    ): List<Movie> {

        return when(mediaType){
            MediaType.MOVIE -> {
                api.getTrendingMovies(mediaType = mediaType)
                    .results.map {
                        it.toDomain()
                    }
            }

            MediaType.TV -> {


                api.getTrendingTv(mediaType = mediaType)
                    .results.map {
                        it.toTvDomain()
                    }
            }
        }
    }

    override suspend fun searchAll(
        page: Int,
        query: String
    ): List<Movie> {
        return api.searchAll(page, query)
            .results.map {
                it.toDomain()
            }
    }


}