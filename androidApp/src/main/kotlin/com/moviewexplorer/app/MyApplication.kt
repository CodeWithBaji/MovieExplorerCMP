package com.moviewexplorer.app

import android.app.Application
import com.moviewexplorer.app.di.initKoin
import com.moviewexplorer.app.utils.AppContextHolder

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        AppContextHolder.context = applicationContext
    }
}