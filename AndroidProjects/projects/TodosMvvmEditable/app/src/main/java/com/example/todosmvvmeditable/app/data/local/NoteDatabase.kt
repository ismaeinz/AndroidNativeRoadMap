package com.example.todosmvvmeditable.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todosmvvmeditable.app.domain.entity.Note
import com.example.todosmvvmeditable.app.domain.repository.Repository


@Database(
    entities = [Note::class], exportSchema = false, version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): Repository
}