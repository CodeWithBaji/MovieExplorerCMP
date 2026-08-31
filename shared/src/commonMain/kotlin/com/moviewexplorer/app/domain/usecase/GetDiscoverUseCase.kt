package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.core.utils.MediaType
import com.moviewexplorer.app.domain.repository.HomeRepository

class GetDiscoverUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(mediaType: MediaType) =
        repository.discover(mediaType)
}