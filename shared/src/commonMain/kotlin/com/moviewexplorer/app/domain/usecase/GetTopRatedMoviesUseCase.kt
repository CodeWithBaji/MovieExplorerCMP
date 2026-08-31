package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.HomeRepository

class GetTopRatedMoviesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(
        page : Int = 1, mediaType: MediaType
    ) =
        repository.topRated(page, mediaType)
}