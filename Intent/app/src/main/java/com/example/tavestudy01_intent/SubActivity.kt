package com.example.tavestudy01_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val btnClose: Button = findViewById(R.id.btnClose)
        btnClose.setOnClickListener {
            finish()
        }

        val DataTextView1: TextView = findViewById(R.id.DataTextView1)
        val DataTextView2: TextView = findViewById(R.id.DataTextView2)

        DataTextView1.text = intent.getStringExtra("Data1")
        DataTextView2.setText("${intent.getIntExtra("Data2",0)}")
    }
}