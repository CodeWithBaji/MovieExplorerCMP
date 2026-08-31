package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.HomeRepository

class GetPopularUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(page: Int, mediaType: MediaType) = homeRepository.getPopular(page, mediaType)
}