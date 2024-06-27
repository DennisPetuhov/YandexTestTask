package com.example.yandextesttask.repository

import com.example.yandextesttask.data.models.RickResponse

interface KtorFitRepository {
    suspend fun fetchData(): RickResponse
}