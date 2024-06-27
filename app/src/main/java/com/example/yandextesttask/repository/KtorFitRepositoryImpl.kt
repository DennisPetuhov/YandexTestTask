package com.example.yandextesttask.repository

import com.example.yandextesttask.data.api.KtorfitApi
import com.example.yandextesttask.data.models.RickResponse

class KtorFitRepositoryImpl(private val apiService: KtorfitApi) : KtorFitRepository {
    override suspend fun fetchData(): RickResponse {
        return apiService.fetchData()
    }
}