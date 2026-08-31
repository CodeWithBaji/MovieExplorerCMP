package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.ListingRepository

class SearchUseCase(
    private val listingRepository: ListingRepository
) {
    suspend operator fun invoke(page: Int, query: String) = listingRepository.searchAll(page, query)
}