package com.example.tavestudy03_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.tavestudy03_coroutine.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    var total = 0
    val started = false

    //핸들러 : 화면의 시간 값 출력
    val handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg) //thread를 통해 값을 쓴다.
            val minute = String.format("%02d",total/60)  //앞의 두 자리를 나타내는
            val second = String.format("%02d",total%60)

            binding.timer.text = "$minute : $second"
        }
    }

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.start.setOnClickListener(){
           thread(start = true){

           while(true) { //무한루프로 1씩 증가된 값을 사용
               Thread.sleep(1000) //1초씩 쉬기

               total += 1
               handler?.sendEmptyMessage(0) //실행하기 위해서 아무것도 없는 값을 handler에 부여
           }
           }
       }
    }
}
