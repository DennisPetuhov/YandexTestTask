package com.example.yandextesttask.di

import org.koin.dsl.module


val appModule = module {
//    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
//    factoryOf(::UserPresenter)
//    viewModelOf(::UserViewModel)
}

// Classical DSL version
//val appModule = module {
//    single<HelloRepository> { HelloRepositoryImpl() }
//    factory { MyPresenter(get()) }
//    viewModel { MyViewModel(get()) }
//}