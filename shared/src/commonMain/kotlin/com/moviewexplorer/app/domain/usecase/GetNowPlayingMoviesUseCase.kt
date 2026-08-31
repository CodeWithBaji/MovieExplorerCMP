package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.HomeRepository

class GetNowPlayingMoviesUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        minDate: String,
        maxDate: String
    ) = homeRepository.getNowPlayingMovie(minDate, maxDate)
}