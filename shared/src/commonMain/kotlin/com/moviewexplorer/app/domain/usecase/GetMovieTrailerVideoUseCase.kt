package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetMovieTrailerVideoUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(movieId: Int) = detailsRepository.getMovieVideos(movieId)
}