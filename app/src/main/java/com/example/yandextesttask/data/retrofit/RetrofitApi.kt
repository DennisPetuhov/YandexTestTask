package com.example.yandextesttask.data.retrofit




import com.example.yandextesttask.data.models.Response
import retrofit2.http.GET

interface RetrofitApi {
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun fetchData(): Response
}