package com.example.tavestudy01_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoSubActivity: Button = findViewById(R.id.btnGoSubActivity)
        btnGoSubActivity.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        val btnThrowValue: Button = findViewById(R.id.btnThrowValue)
        val intent2 = Intent(this, SubActivity::class.java)
        intent2.putExtra("Data1", "Hello World")
        intent2.putExtra("Data2", 2023)
        btnThrowValue.setOnClickListener{startActivity(intent2)}
    }
}