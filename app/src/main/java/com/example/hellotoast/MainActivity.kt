package com.example.hellotoast

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_toast = findViewById<Button>(R.id.button_toast) // 버튼 xml 찾기

        // 버튼 이벤트
        button_toast.setOnClickListener() {
            Toast
                .makeText(this, "toast message", Toast.LENGTH_SHORT)
                .show()
        }
        var mcount = 0
        val show_count = findViewById<TextView>(R.id.show_count)
        show_count.setOnClickListener{
            mcount++
            show_count.text = mcount.toString()
        }
    }

    fun main(){
        setContentView(R.layout.activity_main)
    }
}