package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.core.utils.toMoneyFormat
import com.moviewexplorer.app.data.dto.details.movieDetails.DetailsResponseDto
import com.moviewexplorer.app.data.remote.NetworkConstants.BANNER_PIC_BASE_URL
import com.moviewexplorer.app.data.remote.NetworkConstants.MOVIE_CARD_PIC_BASE_URL
import com.moviewexplorer.app.domain.model.Movie

fun DetailsResponseDto.toDomain() : Movie {
    return Movie(
        id = id?:0,
        originalLanguage = originalLanguage?:"",
        originalTitle = originalTitle?:"",
        overview = overview?:"",
        posterPath = "$MOVIE_CARD_PIC_BASE_URL${posterPath}",
        backdropPath = "$BANNER_PIC_BASE_URL${backdropPath}",
        adult = adult?:false,
        releaseDate = releaseDate?:"",
        genres = genres?.map { it.name } ?: emptyList(),
        languages = spokenLanguages?.map { it.englishName }?: emptyList(),
        budget = budget?.toMoneyFormat(),
        revenue = revenue?.toMoneyFormat(),
        productionCompanies = productionCompanies?:emptyList(),
        productionCountries = productionCountries?:emptyList()
    )
}