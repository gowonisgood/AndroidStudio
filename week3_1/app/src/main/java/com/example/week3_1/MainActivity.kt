package com.example.week3_1
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnChanger : Button
    lateinit var linLayer : LinearLayout

    var number : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "예제 1"

        /////////////Todo///////////////
        //1. widget 배치한 것과 선언한 것 을 이어 준다.
        btnChanger = findViewById<Button>(R.id.ChangeBtn)
        linLayer = findViewById<LinearLayout>(R.id.LinLay)

        btnChanger.setOnTouchListener{ view, motionEvent ->
            /////////////Todo///////////////
            //2. 버튼을 눌렀을때 만
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                if (number % 3 == 0) {
                    linLayer.setBackgroundColor(Color.RED)
                } else if (number % 3 == 1) {
                    linLayer.setBackgroundColor(Color.GREEN)
                } else if (number % 3 == 2) {
                    linLayer.setBackgroundColor(Color.BLUE)
                }
                number++;
                Log.d(number.toString(), "test")
            }
            false
        }
    }
}