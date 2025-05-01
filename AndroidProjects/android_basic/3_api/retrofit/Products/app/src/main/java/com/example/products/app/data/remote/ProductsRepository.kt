package com.example.products.app.data.remote

import com.example.products.app.data.remote.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}