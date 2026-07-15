package com.kotlinground.concurrency.coroutines.builders

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    launch {// GlobalScope can be dropped and launch used
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    this.launch {// same as just launch
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    delay(2000L)

    // output will be:
    // Hello,
    //World!
    //World!
    //World!
    //World!
}