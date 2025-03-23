package com.example.week3_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText;  lateinit var edit2 : EditText
    lateinit var btnAdd : Button;   lateinit var btnSub : Button
    lateinit var btnMul : Button;   lateinit var btnDiv : Button

    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 :  String
    var result : Int? = null
    var number : Int = 0
    var tictok : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = number.toString() + "회 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)


        textResult = findViewById<TextView>(R.id.TextResult)



        btnAdd.setOnTouchListener{ view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                val num1Str = edit1.text.toString()
                val num2Str = edit2.text.toString()
                if(num1Str.isEmpty() || num2Str.isEmpty()){
                    Toast.makeText(this, "두 숫자를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    result = num1Str.toInt() + num2Str.toInt()
                    textResult.text = "계산 결과: $result"
                    edit2.text.clear() // num2 비우기
                }
            }
            false
        }

        btnSub.setOnTouchListener{ view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                val num1Str = edit1.text.toString()
                val num2Str = edit2.text.toString()
                if(num1Str.isEmpty() || num2Str.isEmpty()){
                    Toast.makeText(this, "두 숫자를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    result = num1Str.toInt() - num2Str.toInt()
                    textResult.text = "계산 결과: $result"
                    edit2.text.clear()
                }
            }
            false
        }

        btnMul.setOnTouchListener{ view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                val num1Str = edit1.text.toString()
                val num2Str = edit2.text.toString()
                if(num1Str.isEmpty() || num2Str.isEmpty()){
                    Toast.makeText(this, "두 숫자를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    result = num1Str.toInt() * num2Str.toInt()
                    textResult.text = "계산 결과: $result"
                    edit2.text.clear()
                }
            }
            false
        }

        btnDiv.setOnTouchListener{ view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                val num1Str = edit1.text.toString()
                val num2Str = edit2.text.toString()
                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    Toast.makeText(this, "두 숫자를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    // 0으로 나누는 경우 추가 예외 처리 가능
                    if (num2Str == "0") {
                        Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        result = num1Str.toInt() / num2Str.toInt()
                        textResult.text = "계산 결과: $result"
                        edit2.text.clear()
                    }
                }
            }
            false
        }

    }
}
