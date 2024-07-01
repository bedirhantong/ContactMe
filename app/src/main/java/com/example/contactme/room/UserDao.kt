package com.example.contactme.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactme.entitiy.User

interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun allContacts():List<User>

    @Insert
    suspend fun addContact(user: User)

    @Update
    suspend fun updateContact(user: User)

    @Delete
    suspend fun removeContact(user: User)


    @Query("SELECT * FROM users WHERE userId like '%' || :searchKeyword || '%'")
    suspend fun searchContact(searchKeyword:String):List<User>


}