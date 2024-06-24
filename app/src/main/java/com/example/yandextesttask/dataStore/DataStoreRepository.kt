package com.example.yandextesttask.dataStore

interface DataStoreRepository {
    suspend fun saveText(value:String)
    suspend fun fetchText() : String
}