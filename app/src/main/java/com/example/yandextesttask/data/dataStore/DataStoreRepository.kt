package com.example.yandextesttask.data.dataStore

interface DataStoreRepository {
    suspend fun saveText(value:String)
    suspend fun fetchText() : String
}