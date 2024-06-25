package com.example.yandextesttask.data.retrofit

import com.example.yandextesttask.data.models.Response

interface RetrofitRepository {
    suspend fun fetchData(): Response
}