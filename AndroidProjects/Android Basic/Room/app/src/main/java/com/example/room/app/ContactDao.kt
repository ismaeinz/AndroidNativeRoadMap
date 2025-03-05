package com.example.room.app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    //
    @Upsert
    suspend fun upsertContact(contactEntity: ContactEntity)

    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)

    @Query("SELECT * FROM ContactEntity ORDER BY firstName ASC")
    fun getContactsOrderByFirstName(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM ContactEntity ORDER BY lastName ASC")
    fun getContactsOrderByLastName(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM ContactEntity ORDER BY phoneNumber ASC")
    fun getContactsOrderByPhoneNumber(): Flow<List<ContactEntity>>
}
