package com.kotlinground.concurrency.coroutines.builders

fun main() {
    Thread.sleep(1000L)
    println("World!")

    Thread.sleep(1000L)
    println("World!")

    Thread.sleep(1000L)
    println("World!")

    println("Hello,")

    // output
    //World!
    //World!
    //World!
    //Hello,
}
