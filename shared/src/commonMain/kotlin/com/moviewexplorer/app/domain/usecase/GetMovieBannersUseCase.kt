package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.DetailsRepository
import com.moviewexplorer.app.domain.repository.HomeRepository

class GetMovieBannersUseCase(
    private val repository: DetailsRepository
) {
    suspend operator fun invoke(movieId : Int, mediaType: MediaType) = repository.getDetailsBanner(movieId, mediaType)
}