package com.example.tavestudy03_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.tavestudy03_coroutine.databinding.ActivityMainBinding
import java.util.* //Timer 클래스를 이용한 스케줄링 사용하기 위해 Import
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    //멤버 변수로 ActivityMainBinding 객체의 변수를 선언
    private lateinit var binding: ActivityMainBinding

    //사용할 변수들 선언
    var isRunning = false
    var Timer: Timer? = null
    var total = 0


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       //ActivityMainBiding 객체를 구해서 ContentView로 등록
       binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
       //이후에 각각의 위젯을 위젯에 binding.아이디로 접근 가능


       fun start(){
           binding.start.text="일시정지"
           isRunning = true

           Timer = timer(period = 10){
               //코틀린에서 제공하는 timer 함수로 일정한 주기로 반복하는 동작을 수행할 때 사용됨.
               //10밀리초 단위로 시간을 증가시키도록 작성. 10밀리초 단위의 타이머 동작.
               // 1millisec = 1/1000 sec
               total++ //시간진행 시작

               //분, 초, 밀리초
               val minute = total/6000
               val second = (total%6000)/100
               val millisecond = total % 100

               //UI 스레드
               runOnUiThread{ //runOnUiThread를 사용 -> UI 작업이 백그라운드 스레드가 아닌 UI 스레드(메인 스레드)에서 일어남
                   if(isRunning) { //isRunning이 true일 경우에만 UI가 업데이트
                       binding.timer.text = "${minute} : ${second} : ${millisecond}"
                   }
               }
           }
       }

       fun pause(){
           binding.start.text = "시작"

           isRunning = false
           Timer?.cancel() //타이머 멈추기
       }

       fun clear(){
           Timer?.cancel()

           binding.start.text = "시작"
           isRunning = false

           total = 0
           binding.timer.text = "00:00:00"
       }


       //버튼 구현
       //START 버튼
       binding.start.setOnClickListener() {
           if (isRunning) { //false인 경우 pause()함수 실행
               pause()
           } else start()
       }

       //Clear 버튼 구현
       binding.clear.setOnClickListener(){
           clear() //clear 함수 실행
       }

    }
}
