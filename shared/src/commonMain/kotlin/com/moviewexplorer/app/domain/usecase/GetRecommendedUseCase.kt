package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetRecommendedUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(movieId: Int, mediaType: MediaType) = detailsRepository.getRecommended(movieId, mediaType)
}