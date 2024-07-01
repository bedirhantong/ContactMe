package com.example.contactme.room

import androidx.room.RoomDatabase
import com.example.contactme.entitiy.User
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [User::class],version = 1)
abstract class Database: RoomDatabase() {
    abstract fun userDao():UserDao

//    companion object{
//        var INSTANCE:Database? = null
//
//        fun accessDatabase(context: Context): Database? {
//            if (INSTANCE==null){
//                synchronized(Database::class){
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        Database::class.java,
//                        "rehber.sqlite").createFromAsset("rehber.sqlite").build()
//                }
//            }
//            return INSTANCE
//        }
//    }
}