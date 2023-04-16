package com.example.tavestudy01_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //생명주기 예제
        Toast.makeText(this, "onCreate 호출 됨", Toast.LENGTH_LONG).show()

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

        val btnUrl: Button = findViewById(R.id.btnUrl)
        val url = "https://www.naver.com/"
        val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        btnUrl.setOnClickListener{startActivity(intent3)}
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart 호출 됨", Toast.LENGTH_LONG).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume 호출 됨", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause 호출 됨", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop 호출 됨", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart 호출 됨", Toast.LENGTH_LONG).show()
    }
}