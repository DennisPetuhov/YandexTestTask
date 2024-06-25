package com.example.yandextesttask.di

import com.example.yandextesttask.data.api.KtorfitApi
import com.example.yandextesttask.repository.KtorFitRepositoryImpl
import com.example.yandextesttask.repository.KtorfitRepository
import com.example.yandextesttask.ui.MainScreenViewModel
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun apiModule() = module {
    single { CoroutineScope(Dispatchers.Default + SupervisorJob()) }
//    single<Json> { createJson() }
//    single<Ktorfit> { createHttpClient(get(), get()) }
//    single<KtorfitApi> { provideKtorApi(get()) }
    single<KtorfitRepository> { KtorFitRepositoryImpl(get()) }
    viewModel { MainScreenViewModel() }
    single<KtorfitApi> { provideKtorFitApi() }

}


fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(
    httpClientEngine: HttpClientEngine,
    json: Json,
    enableNetworkLogs: Boolean
): Ktorfit {
    val client = HttpClient(httpClientEngine) {
        defaultRequest { url(KtorfitApi.baseUrl) }
        install(ContentNegotiation) { json(json) }
//        if (enableNetworkLogs) {
//            install(Logging) {
//                logger = Logger.DEFAULT
//                level = LogLevel.INFO
//            }
//        }
    }
    return Ktorfit.Builder().httpClient(client).build()
}
fun provideKtorFitApi(): KtorfitApi {
    return Ktorfit.Builder().baseUrl(KtorfitApi.baseUrl).build().create<KtorfitApi>()
}
val ktorfit = Ktorfit.Builder().baseUrl(KtorfitApi.baseUrl).build()
val exampleApi = ktorfit.create<KtorfitApi>()

fun provideKtorApi(ktorfit: Ktorfit): KtorfitApi {

    return ktorfit.create<KtorfitApi>()
}
//fun injectApiClient(ktorfit: FakeApi): FakeApi = ktorfit

