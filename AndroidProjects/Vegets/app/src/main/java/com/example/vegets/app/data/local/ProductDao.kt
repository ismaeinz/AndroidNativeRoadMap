package com.example.vegets.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM ProductEntity")
    suspend fun getAllProductsFromDb(): List<Product>

    @Insert
    suspend fun saveAllProductsToDb(products: List<Product>)

}