package com.example.marvelclient

import android.app.Application
import com.example.marvelclient.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        koin()
    }

    private fun koin() = startKoin {
        androidContext(this@App)
        modules(appComponent)
    }
}