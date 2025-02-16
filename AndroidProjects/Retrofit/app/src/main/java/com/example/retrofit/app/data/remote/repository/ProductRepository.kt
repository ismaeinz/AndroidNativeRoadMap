package com.example.retrofit.app.data.remote.repository

import com.example.retrofit.app.data.remote.Result
import com.example.retrofit.app.data.remote.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}