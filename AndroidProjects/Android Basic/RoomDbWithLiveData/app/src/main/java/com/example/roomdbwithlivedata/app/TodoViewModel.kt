package com.example.roomdbwithlivedata.app

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbwithlivedata.app.db.App
import com.example.roomdbwithlivedata.app.db.TodoDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
    private val todoDao = TodoDataBase.getDaoInstance(App.getApplicationContext())
    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()

    fun addTodo(title: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            viewModelScope.launch(Dispatchers.IO) {
                todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
            }
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)

        }
    }

}