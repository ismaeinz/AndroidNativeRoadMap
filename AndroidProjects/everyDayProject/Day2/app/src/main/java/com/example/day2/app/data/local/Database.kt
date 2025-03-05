package com.example.day2.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [DatabaseModel::class],
    version = 1,
    exportSchema = false
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object {
        const val DATABASE_NAME: String = "Room Database"

        @Volatile
        var INSTANCE: MyDataBase? = null

        fun getDatabase(context: Context): MyDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance

            }
        }
    }
}