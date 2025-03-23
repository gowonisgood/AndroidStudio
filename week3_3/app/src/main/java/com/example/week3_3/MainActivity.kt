package com.example.week3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    lateinit var btnLeft : Button; lateinit var btnRight : Button;
    lateinit var img : ImageView
    var idx : Int = 0
    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "예제3"

        btnLeft = findViewById<Button>(R.id.leftBtn)
        btnRight = findViewById<Button>(R.id.rightBtn)

        img = findViewById<ImageView>(R.id.imgView)

        btnLeft.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                count--;
                if (count < 0) {
                    count += 26
                }
                changeImg(count)
            }
            false
        }
        btnRight.setOnTouchListener { view, motionEvent ->
            /////////////Todo///////////////
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                count++;
                if (count > 25) {
                    count -= 26
                }
                changeImg(count)
            }
            false
        }
    }
    fun changeImg(idx : Int){
        when (idx){
            0 -> img.setImageResource(R.drawable.a)
            1 -> img.setImageResource(R.drawable.b)
            2 -> img.setImageResource(R.drawable.c)
            3 -> img.setImageResource(R.drawable.d)
            4 -> img.setImageResource(R.drawable.e)
            5 -> img.setImageResource(R.drawable.f)
            6 -> img.setImageResource(R.drawable.g)
            7 -> img.setImageResource(R.drawable.h)
            8 -> img.setImageResource(R.drawable.i)
            9 -> img.setImageResource(R.drawable.j)
            10 -> img.setImageResource(R.drawable.k)
            11 -> img.setImageResource(R.drawable.l)
            12 -> img.setImageResource(R.drawable.m)
            13 -> img.setImageResource(R.drawable.n)
            14 -> img.setImageResource(R.drawable.o)
            15 -> img.setImageResource(R.drawable.p)
            16 -> img.setImageResource(R.drawable.q)
            17 -> img.setImageResource(R.drawable.r)
            18 -> img.setImageResource(R.drawable.s)
            19 -> img.setImageResource(R.drawable.t)
            20 -> img.setImageResource(R.drawable.u)
            21 -> img.setImageResource(R.drawable.v)
            22 -> img.setImageResource(R.drawable.w)
            23 -> img.setImageResource(R.drawable.x)
            24 -> img.setImageResource(R.drawable.y)
            25 -> img.setImageResource(R.drawable.z)
        }
    }
}