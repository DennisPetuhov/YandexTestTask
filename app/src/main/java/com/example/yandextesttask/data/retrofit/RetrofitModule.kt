package com.example.yandextesttask.data.retrofit


import com.example.yandextesttask.ui.MainScreenViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.scalars.ScalarsConverterFactory

val retrofitModuile = module {
    single <RetrofitApi>{ provideRetrofitApi() }
    single<RetrofitRepository> { RetrofitReposImpl(get()) }
    viewModel { MainScreenViewModel() }

}




fun provideRetrofitApi(): RetrofitApi {

    val a = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
   return a.create(RetrofitApi::class.java)
}