package com.example.yandextesttask.data.models

data class Response(
    val offers: List<Offer>
)
data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)
data class Price(
    val value: Int
)