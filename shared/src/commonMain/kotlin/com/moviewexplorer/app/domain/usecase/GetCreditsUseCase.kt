package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetCreditsUseCase(
    private val detailsRepository: DetailsRepository
) {

    suspend operator fun invoke(movieId: Int) = detailsRepository.getMovieCastAndCrew(movieId)
}