package com.example.roomdbwithlivedata.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdbwithlivedata.app.Todo

@Database(
    entities = [Todo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TodoDataBase : RoomDatabase() {
    //ازاي اربط الـdao بالـdb بعرف منه انستانس
    abstract val dao: TodoDao

    companion object {
        //        هتخليها متاحه في الthreads التانيه
        @Volatile
        private var daoInstance: TodoDao? = null

        private fun buildDb(context: Context): TodoDataBase =
            Room.databaseBuilder(
                context.applicationContext,
                TodoDataBase::class.java,
                "contacts.db"
            ).fallbackToDestructiveMigration().build()

        fun getDaoInstance(context: Context): TodoDao {
//انا عايز يكون عندي ريفرانس واحد
            synchronized(this) {
                if (daoInstance == null) {
                    daoInstance = buildDb(context).dao
                }
                return daoInstance as TodoDao
            }

        }

    }
}