package com.example.roomdbwithlivedata.app.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbwithlivedata.app.Todo

@Dao
interface TodoDao {
    @Insert
    fun saveAllTodo(todos: List<Todo>)

    @Query("SELECT * FROM Todo ")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE FROM TODO where id=:id")
    fun deleteTodo(id: Int)

    @Query("UPDATE Todo SET title=:title ")
    fun editTodo(title: String)
}