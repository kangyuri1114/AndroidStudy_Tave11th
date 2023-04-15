package com.example.tavestudy03_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tavestudy03_coroutine.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // private 선언 이유 - 캡슐화(보안성, 메모리 누수 방지)
    private var isRunning = false
    private var timer: Timer? = null
    private var total = 0

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(binding.root)

       /**
        * Start 버튼
        *  Condition(isRunning) - false인 경우 실행
        * */
       binding.start.setOnClickListener {
           if (isRunning) {
               pause()
           } else start()
       }

       /**
        * Clear 버튼
        *  Timer Stop & Reset
        *  00:00:00 로 초기화
        */
       binding.clear.setOnClickListener { clear() }
    }



    /**
     * Tip) 1millis = 1/1000 sec
     *
     * Timer =
     *  코틀린에서 제공하는 timer 함수로 일정한 주기로 반복하는 동작을 수행할 때 사용됨.
     *  '10밀리초 단위로 시간을 증가시키도록 작성. 10밀리초 단위의 타이머 동작.
     * total++ : 시간 진행
     *
     * */
    private fun start() {
        binding.start.text="일시정지"
        isRunning = true

        timer = timer(period = 10){
            total++

            val minute = total/6000
            val second = (total%6000)/100
            val millisecond = total % 100

            runOnUiThread{
                if (isRunning) {
                    binding.timer.text =
                        String.format("%02d : %02d : %02d", minute, second, millisecond)

                    if (minute == 99 && second == 59 && millisecond == 99) {
                        pause()
                        Toast.makeText(
                            applicationContext,
                            "타이머를 중지합니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    /**
     * pause()
     *  - Timer.cancel() : 시간초 정지(타이머 정지지)
     * */
   private fun pause(){
        binding.start.text = "시작"
        isRunning = false
        timer?.cancel()
    }

    private fun clear(){
        timer?.cancel()
        binding.start.text = "시작"
        isRunning = false
        total = 0
        binding.timer.text = getText(R.string.timer)
    }
}
