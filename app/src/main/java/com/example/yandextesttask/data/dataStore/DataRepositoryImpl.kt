package com.example.yandextesttask.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

class DataStoreRepositoryImpl(private val context: Context) : DataStoreRepository {
    private val MY_EXAMPLE = stringPreferencesKey("example")

    override suspend fun saveText(value: String) {
        context.dataStore.edit { preferences ->
            preferences[MY_EXAMPLE] = value
        }
    }

    override suspend fun fetchText(): String {
        val preferences = context.dataStore.data.first()
        return preferences[MY_EXAMPLE] ?: "Default Value"
    }
}