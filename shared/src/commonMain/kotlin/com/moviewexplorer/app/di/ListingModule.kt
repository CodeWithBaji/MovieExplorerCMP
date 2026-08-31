package com.moviewexplorer.app.di

import com.moviewexplorer.app.data.remote.MovieApiService
import com.moviewexplorer.app.data.remote.MovieApiServiceImpl
import com.moviewexplorer.app.data.repository.HomeRepositoryImpl
import com.moviewexplorer.app.data.repository.ListingRepositoryImpl
import com.moviewexplorer.app.domain.repository.HomeRepository
import com.moviewexplorer.app.domain.repository.ListingRepository
import com.moviewexplorer.app.domain.usecase.GetTopRatedMoviesUseCase
import com.moviewexplorer.app.domain.usecase.GetTrendingUseCase
import com.moviewexplorer.app.domain.usecase.SearchUseCase
import com.moviewexplorer.app.features.listingScreen.ListingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val listingModule = module {

    single<MovieApiService> {
        MovieApiServiceImpl(get())
    }

    single<ListingRepository> {
        ListingRepositoryImpl(
            get()
        )
    }


    factory {
        GetTopRatedMoviesUseCase(get())
    }

    factory {
        GetTrendingUseCase(get())
    }

    factory {
        SearchUseCase(get())
    }



    viewModel {
        ListingViewModel(get(), get(),get(), get())
    }
}