package com.example.todosmvvmeditable.app.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note") // name of table of DB =>note
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val content: String = ""
)
