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
    var started = false

    //핸들러 : 화면의 시간 값 출력
    val handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg) //thread를 통해 값을 쓴다.
            val minute = String.format("%02d",total/60)  //앞의 두 자리를 나타내는
            val second = String.format("%02d",total%60)
            val millisecond = String.format("%02d",total/1000)

            binding.timer.text = "$minute : $second : $millisecond"
        }
    }

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.start.setOnClickListener(){
           started = true

           thread(start = true){
           while(started) { //무한루프로 1씩 증가된 값을 사용
               Thread.sleep(1000) //1초씩 쉬기
                if(started) { //stop 시에도 반복문이 돌 수 있기 때문에 started 한번 더 작성
                    total += 1
                    handler?.sendEmptyMessage(0) //실행하기 위해서 아무것도 없는 값을 handler에 부여
                    }
                }
           }
       }

       binding.pause.setOnClickListener(){
           if(started){
               started = false
               total = 0
           }
       }

       binding.clear.setOnClickListener(){

           started = false
           total = 0
           binding.timer.text = "00:00:00"

       }
    }
}
