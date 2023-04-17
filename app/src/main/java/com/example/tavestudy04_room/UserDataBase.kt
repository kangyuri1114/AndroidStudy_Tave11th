package com.example.tavestudy04_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserTable::class], version = 1, exportSchema = false )
abstract class UserDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao

}