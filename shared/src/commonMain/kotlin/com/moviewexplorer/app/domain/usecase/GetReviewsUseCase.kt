package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetReviewsUseCase(
    private val detailsRepository: DetailsRepository
){

    suspend operator fun invoke(movieId: Int) = detailsRepository.getMovieReviews(movieId)

}