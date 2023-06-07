package com.example.tavestudy04_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_table")
data class UserTable(
    @PrimaryKey(autoGenerate = true)
    val no: Int,

    @ColumnInfo("name")
    val name: String
)