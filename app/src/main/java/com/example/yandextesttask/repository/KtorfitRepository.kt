package com.example.yandextesttask.repository

import com.example.yandextesttask.data.models.Response

interface KtorfitRepository {
   suspend fun  fetchData(): Response
}