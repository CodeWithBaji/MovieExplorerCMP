package com.moviewexplorer.app.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    networkModule,
    homeModule,
    detailsModule,
    listingModule
)