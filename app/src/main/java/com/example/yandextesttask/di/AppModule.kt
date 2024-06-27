package com.example.yandextesttask.di


import com.example.yandextesttask.repository.KtorFitRepository
import com.example.yandextesttask.repository.KtorFitRepositoryImpl
import com.example.yandextesttask.ui.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {
    single<KtorFitRepository> { KtorFitRepositoryImpl(apiService = get()) }
    viewModel { MainScreenViewModel(ktorApi = get()) }
}


// Classical DSL version
//val appModule = module {
//    single<HelloRepository> { HelloRepositoryImpl() }
//    factory { MyPresenter(get()) }
//    viewModel { MyViewModel(get()) }
//}