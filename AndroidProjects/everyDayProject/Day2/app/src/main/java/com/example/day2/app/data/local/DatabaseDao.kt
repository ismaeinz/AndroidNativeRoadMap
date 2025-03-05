package com.example.day2.app.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewTask(databaseModel: DatabaseModel)

    @Query("SELECT * FROM DatabaseModel ORDER BY id DESC")
    fun getAllTask(): LiveData<List<DatabaseModel>>

    @Query("DELETE FROM DatabaseModel WHERE id=:taskID")
    suspend fun removeTask(taskID: Int)

    @Query("UPDATE DatabaseModel SET taskName=:taskName , description=:description WHERE id")
    suspend fun editTask(taskName: String, description: String)


}