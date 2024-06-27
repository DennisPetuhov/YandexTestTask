package com.example.yandextesttask.data.api

import com.example.yandextesttask.data.models.RickResponse
import de.jensklingenberg.ktorfit.http.GET

interface KtorfitApi {
//    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
//    suspend fun fetchData(): Response

    @GET("api")
    suspend fun fetchData(): RickResponse

    companion object {
        //        const val baseUrl = "https://run.mocky.io/v3/"
        const val baseUrl = "https://rickandmortyapi.com/"
    }
}
