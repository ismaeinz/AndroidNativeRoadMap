package com.example.products.app.data

import coil.network.HttpException
import com.example.products.app.data.remote.Api
import com.example.products.app.data.remote.ProductsRepository
import com.example.products.app.data.remote.Result
import com.example.products.app.data.remote.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class ProductsRepositoryImpl(
    private val api: Api
) : ProductsRepository {
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromApi = try {
                api.getProductsList()
            } catch (e: IOException) {
                emit(
                    Result.Error(message = "Error")
                )
                return@flow
            } catch (e: HttpException) {
                emit(
                    Result.Error(message = "Error")
                )
                return@flow
            } catch (e: Exception) {
                emit(
                    Result.Error(message = "Error")
                )
                return@flow

            }
            emit(
                Result.Success(
                    productsFromApi.products
                )
            )
        }
    }

}