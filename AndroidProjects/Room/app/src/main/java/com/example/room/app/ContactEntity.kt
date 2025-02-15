package com.example.room.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ContactEntity")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
)
