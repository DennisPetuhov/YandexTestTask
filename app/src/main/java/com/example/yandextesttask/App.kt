package com.example.yandextesttask

import android.app.Application
import android.content.Context
import com.example.yandextesttask.data.retrofit.retrofitModuile
import com.example.yandextesttask.di.apiModule
import com.example.yandextesttask.di.dataStoreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            androidContext(this@App)
//            modules(listOf(dataStoreModule(), apiModule(), appModule()))
//            modules(retrofitModuile, dataStoreModule())
            modules( dataStoreModule(), apiModule())
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}