package com.example.tavestudy04_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.tavestudy04_room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var userDataBase: UserDataBase
    private val mainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        userDataBase =
            Room.databaseBuilder(applicationContext, UserDataBase::class.java,"user_db")
            .build()

        mainBinding.Insert.setOnClickListener() {
            CoroutineScope(Dispatchers.Main).launch {
                val userList = withContext(Dispatchers.IO){
                    userDataBase.userDao().getAll().toString()
                }

                mainBinding.userList.text = userList
            }
        }
    }
}