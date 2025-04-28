package com.example.simpleapicallingwithretrofit.app.domain.model

data class Product(
    val products: List<ProductX> = listOf(),
    val total: Int = 0, // 194
    val skip: Int = 0, // 0
    val limit: Int = 0 // 30
)