package com.moviewexplorer.app.domain.usecase

import com.moviewexplorer.app.domain.repository.DetailsRepository

class GetMovieDetailsUseCase(private val repository: DetailsRepository) {

    suspend operator fun invoke(movieId : Int) = repository.getMovieDetails(movieId)

}