package com.example.yandextesttask.di

import android.content.Context
import com.example.yandextesttask.dataStore.DataStoreRepository
import com.example.yandextesttask.dataStore.DataStoreRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module



    val dataStoreModule = module {
        single { provideDataStoreRepository(androidContext()) }
    }

    fun provideDataStoreRepository(context: Context): DataStoreRepository
            = DataStoreRepositoryImpl(context)
