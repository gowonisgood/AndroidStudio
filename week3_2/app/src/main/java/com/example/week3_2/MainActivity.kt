package com.example.week3_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    /////////////Todo///////////////
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "예제 2번"

        btn1 = findViewById<Button>(R.id.Btn1)
        btn2 = findViewById<Button>(R.id.Btn2)
        btn3 = findViewById<Button>(R.id.Btn3)

        btn1.setOnTouchListener{ view, motionEvent ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
            btn3.visibility = View.INVISIBLE
            true
        }
        btn2.setOnTouchListener{ view, motionEvent ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.VISIBLE
            true
        }
        btn3.setOnTouchListener{ view, motionEvent ->
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            true
        }
    }
}