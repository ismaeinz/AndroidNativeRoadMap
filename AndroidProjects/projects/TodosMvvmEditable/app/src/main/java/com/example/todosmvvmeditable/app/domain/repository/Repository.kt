package com.example.todosmvvmeditable.app.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todosmvvmeditable.app.domain.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao // function that work with Db
interface Repository {
    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("select * from note")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from note where id=:id")
    suspend fun getByIdNote(id: Int): Note
}