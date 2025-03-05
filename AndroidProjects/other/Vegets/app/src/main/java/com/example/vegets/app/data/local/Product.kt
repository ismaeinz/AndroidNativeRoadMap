package com.example.vegets.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ProductEntity")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val image: String,
    val price: Int,
    val category: String,
)
