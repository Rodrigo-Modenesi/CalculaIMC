package com.example.pucminas_iec

fun main(){
    val frutas = listOf("apple", "banana", "kiwifruit")
    for (fruta in frutas) {
        println(fruta)
    }
    for (index in frutas.indices) {
        println("${index+1} é ${frutas[index]} ")
    }
    var index = 0

    while (index < frutas.size) {
        println ("Item ${index+1} é ${frutas[index]}")
    index++
    }
}