package com.moviewexplorer.app.di

import com.moviewexplorer.app.data.remote.MovieApiService
import com.moviewexplorer.app.data.remote.MovieApiServiceImpl
import com.moviewexplorer.app.data.repository.HomeRepositoryImpl
import com.moviewexplorer.app.domain.repository.HomeRepository
import com.moviewexplorer.app.domain.usecase.GetDiscoverUseCase
import com.moviewexplorer.app.domain.usecase.GetNowPlayingMoviesUseCase
import com.moviewexplorer.app.domain.usecase.GetPopularUseCase
import com.moviewexplorer.app.domain.usecase.GetTopRatedMoviesUseCase
import com.moviewexplorer.app.features.home.common.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    single<MovieApiService> {
        MovieApiServiceImpl(get())
    }


    single<HomeRepository> {
        HomeRepositoryImpl(
            get()
        )
    }

    factory {
        GetDiscoverUseCase(get())
    }



    factory {
        GetTopRatedMoviesUseCase(get())
    }


    factory {
        GetNowPlayingMoviesUseCase(get())
    }

    factory {
        GetPopularUseCase(get())
    }



    viewModel {
        HomeViewModel(get(), get(), get(), get())
    }
}