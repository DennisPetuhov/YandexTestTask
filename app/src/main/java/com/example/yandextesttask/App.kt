package com.example.yandextesttask

import android.app.Application
import android.content.Context
import com.example.yandextesttask.di.apiModule
import com.example.yandextesttask.di.appModule
import com.example.yandextesttask.di.dataStoreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            androidContext(this@App)
            modules(dataStoreModule(), apiModule(), appModule())
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}