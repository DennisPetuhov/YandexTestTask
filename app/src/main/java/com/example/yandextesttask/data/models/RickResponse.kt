package com.example.yandextesttask.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RickResponse(
    val characters: String,
    var episodes: String,
    val locations: String
)