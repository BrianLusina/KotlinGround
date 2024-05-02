package com.kotlinground.concurrency.coroutines.builders

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.runBlocking

fun main() {
    // blocks the thread it was started on whenever its coroutine is suspended. Similar to suspending main
    runBlocking {
        // this will behave like Thread.sleep(1000L)
        delay(1000L)
        println("World!")
    }
    runBlocking {
        delay(1000L)
        println("World!")
    }
    runBlocking {
        delay(1000L)
        println("World!")
    }

    println("Hello,")

    // output
    //World!
    //World!
    //World!
    //Hello,
}
