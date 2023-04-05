package com.example.tavestudy02_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //생명주기 예제
        Toast.makeText(this, "onCreate 호출 됨", Toast.LENGTH_LONG).show()
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