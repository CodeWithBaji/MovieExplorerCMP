package com.moviewexplorer.app.data.mapper


import com.moviewexplorer.app.core.components.genres.GenreConstants
import com.moviewexplorer.app.data.dto.tvDto.Result
import com.moviewexplorer.app.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.moviewexplorer.app.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.moviewexplorer.app.domain.model.Movie

fun Result.toTvDomain(): Movie {
    return Movie(
        id = id?:0,
        originalLanguage = originalLanguage?:"",
        originalTitle = originalName?:"",
        overview = overview?:"",
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath}",
        adult = adult?:false,
        releaseDate = firstAirDate?:"",
        genres = genreIds
            ?.mapNotNull { GenreConstants.tvGenres[it] }
            ?: emptyList(),
        languages = emptyList()
    )
}