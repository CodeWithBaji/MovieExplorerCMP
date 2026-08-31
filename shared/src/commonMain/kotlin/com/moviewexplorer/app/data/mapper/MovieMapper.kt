package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.core.components.genres.GenreConstants
import com.moviewexplorer.app.data.dto.movieDto.Result
import com.moviewexplorer.app.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.moviewexplorer.app.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.moviewexplorer.app.domain.model.Movie


fun Result.toDomain(): Movie {
    return Movie(
        id = id ?: 0,
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle ?: originalName.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath.orEmpty()}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath.orEmpty()}",
        adult = adult ?: false,
        releaseDate = releaseDate ?: firstAirDate.orEmpty(),
        genres = genreIds
            ?.mapNotNull { GenreConstants.movieGenres[it] ?: GenreConstants.tvGenres[it] }
            .orEmpty(),
        languages = emptyList(),
        mediaType = mediaType
    )
}
