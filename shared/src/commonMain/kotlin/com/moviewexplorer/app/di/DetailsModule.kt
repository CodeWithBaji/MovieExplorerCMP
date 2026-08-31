package com.moviewexplorer.app.di

import com.moviewexplorer.app.data.repository.DetailsRepositoryImpl
import com.moviewexplorer.app.domain.repository.DetailsRepository
import com.moviewexplorer.app.domain.usecase.GetCreditsUseCase
import com.moviewexplorer.app.domain.usecase.GetMovieBannersUseCase
import com.moviewexplorer.app.domain.usecase.GetMovieDetailsUseCase
import com.moviewexplorer.app.domain.usecase.GetMovieTrailerVideoUseCase
import com.moviewexplorer.app.domain.usecase.GetRecommendedUseCase
import com.moviewexplorer.app.domain.usecase.GetReviewsUseCase
import com.moviewexplorer.app.domain.usecase.GetSimilarUseCase
import com.moviewexplorer.app.features.details.common.DetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {

    single<DetailsRepository> {
        DetailsRepositoryImpl(
            get()
        )
    }

    factory {
        GetMovieBannersUseCase(get())
    }

    factory {
        GetMovieDetailsUseCase(get())
    }


    factory {
        GetCreditsUseCase(get())
    }

    factory {
        GetRecommendedUseCase(get())
    }

    factory {
        GetSimilarUseCase(get())
    }



    factory {
        GetMovieTrailerVideoUseCase(get())
    }

    factory {
        GetReviewsUseCase(get())
    }

    viewModel {
        DetailsViewModel(get(), get(), get(), get(), get(), get(), get())
    }
}