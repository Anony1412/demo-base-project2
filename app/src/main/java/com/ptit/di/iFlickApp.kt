package com.ptit.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class iFlickApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@iFlickApp)
            modules (listOf(apiModule, sourceModule, viewModelModule))
        }
    }
}
