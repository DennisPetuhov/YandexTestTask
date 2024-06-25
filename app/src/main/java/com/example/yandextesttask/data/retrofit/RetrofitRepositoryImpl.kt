package com.example.yandextesttask.data.retrofit


class RetrofitReposImpl(private val api: RetrofitApi) : RetrofitRepository {
    override suspend fun fetchData() = api.fetchData()
}