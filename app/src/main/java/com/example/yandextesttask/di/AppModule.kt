//package com.example.yandextesttask.di
//
//
//import com.example.yandextesttask.data.api.MyApi
//import com.example.yandextesttask.repository.FakeApi
//import com.example.yandextesttask.repository.FakeRepo
//import com.example.yandextesttask.repository.FakeRepoImpl
//import com.example.yandextesttask.repository.Repository
//import com.example.yandextesttask.repository.RepositoryImpl
//import com.example.yandextesttask.ui.MainScreenViewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//
//fun appModule() = module {
////    single<Repository> { provideRepository(get()) }
//    single<FakeRepo> { provideFakeRepository(get()) }
//    single<FakeApi> { providefakeApi()  }
//    single { provideRepositoryImp(get()) }
//    viewModel { MainScreenViewModel() }
//
//}
//
//
//fun provideRepositoryImp(api: MyApi): RepositoryImpl = RepositoryImpl(api)
//fun provideFakeRepository(fakeApi:FakeApi): FakeRepo = FakeRepoImpl(fakeApi)
//fun providefakeApi(): FakeApi = FakeApi()

// Classical DSL version
//val appModule = module {
//    single<HelloRepository> { HelloRepositoryImpl() }
//    factory { MyPresenter(get()) }
//    viewModel { MyViewModel(get()) }
//}