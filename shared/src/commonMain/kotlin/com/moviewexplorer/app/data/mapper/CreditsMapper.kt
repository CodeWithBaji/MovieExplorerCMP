package com.moviewexplorer.app.data.mapper

import com.moviewexplorer.app.data.dto.details.castAndCrew.CastAndCrewResponseDto
import com.moviewexplorer.app.data.remote.NetworkConstants.PROFILE_PIC_BASE_URL
import com.moviewexplorer.app.domain.model.CastAndCrew
import com.moviewexplorer.app.domain.model.Credits

fun CastAndCrewResponseDto.toDomain() = Credits(

    casts = cast?.map {
        CastAndCrew(
            profilePath = it.profilePath?.let { path ->
                "$PROFILE_PIC_BASE_URL$path"
            }.orEmpty(),
            name = it.name.orEmpty(),
            character = it.character.orEmpty()
        )
    } ?: emptyList(),

    crew = crew?.map {
        CastAndCrew(
            profilePath = it.profilePath?.let { path ->
                "$PROFILE_PIC_BASE_URL$path"
            }.orEmpty(),
            name = it.name.orEmpty(),
            character = it.job.orEmpty()
        )
    } ?: emptyList()
)