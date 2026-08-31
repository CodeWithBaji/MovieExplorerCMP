package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetSimilarUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(movieId: Int, mediaType: MediaType) = detailsRepository.getSimilar(movieId, mediaType)
}