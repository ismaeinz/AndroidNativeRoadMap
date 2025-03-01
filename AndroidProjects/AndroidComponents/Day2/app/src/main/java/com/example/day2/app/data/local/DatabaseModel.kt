package com.example.day2.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("DatabaseModel")
data class DatabaseModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val taskName: String = "",
    val description: String = ""
)