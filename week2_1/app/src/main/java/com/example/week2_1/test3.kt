package com.example.week2_1


fun main(){
    var inp = readLine()
    var notUpper: MutableList<Char>  = mutableListOf()
    var flag: Int = 0

    inp?.let { // `a`가 null이 아닐 때만 실행
        for (ch in it) {
            if(!ch.isLowerCase())  {
                flag = 1
                notUpper.add(ch)
                continue
            }
        }
    }

    if(flag==1){
        println("error with = "+ notUpper.joinToString(""))
    }
    else{
        println(inp?.uppercase())
    }
}