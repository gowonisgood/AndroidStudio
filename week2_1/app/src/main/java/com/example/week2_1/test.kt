package com.example.week2_1

fun main(){
   val a = readLine()
   println("입력 받을 숫자: ${a!!}")

    for(i in 1..a.toInt()){
        if(i % 2 != 0){
            print("$i ")
        }
    }
}