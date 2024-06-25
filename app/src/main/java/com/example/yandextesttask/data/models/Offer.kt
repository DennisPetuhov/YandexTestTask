package com.example.yandextesttask.data.models

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)
data class Price(
    val value: Int
)