package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.ListingRepository

class GetTrendingUseCase(
    private val listingRepository: ListingRepository
) {
    suspend operator fun invoke(page: Int, mediaType: MediaType) =  listingRepository.getTrending(page, mediaType)
}