package com.example.tavestudy04_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @DAO - 데이터베이스에 접근하여 DML 쿼리 (SELECT, INSERT, UPDATE, DELETE) 실행 메서드 모음
 *
 * */
@Dao
    interface UserDao{
        @Query("select * from user_table")
        fun getAll(): List<UserTable>

        @Insert
        fun insertUser(user: UserTable)
    }
