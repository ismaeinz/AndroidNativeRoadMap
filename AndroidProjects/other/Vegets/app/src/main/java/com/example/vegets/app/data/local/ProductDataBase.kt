package com.example.vegets.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Product::class], version = 1, exportSchema = false
)

abstract class ProductDataBase : RoomDatabase() {
    abstract val dao: ProductDao

    companion object {
        @Volatile
        private var daoInstance: ProductDao? = null

        private fun buildDb(context: Context): ProductDataBase =
            Room.databaseBuilder(
                context.applicationContext,
                ProductDataBase::class.java,
                "contacts.db"
            ).fallbackToDestructiveMigration().build()

        fun getDaoInstance(context: Context): ProductDao {
            synchronized(this) {

                if (daoInstance == null) {
                    daoInstance = buildDb(context).dao
                }
                return daoInstance as ProductDao
            }

        }
    }
}