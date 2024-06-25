package com.example.yandextesttask.repository

import com.example.yandextesttask.data.api.KtorfitApi
import com.example.yandextesttask.data.models.Response

class KtorFitRepositoryImpl(val apiService: KtorfitApi) : KtorfitRepository{
    override suspend fun fetchData(): Response {
        return apiService.fetchData()
    }
}