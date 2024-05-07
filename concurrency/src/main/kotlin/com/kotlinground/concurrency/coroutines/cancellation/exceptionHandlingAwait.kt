package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope

class MyException : Throwable()

suspend fun main(): Unit = supervisorScope {
    val str1 = async<String> {
        // exception thrown in this scope does not cancel the parent
        delay(1000)
        throw MyException()
    }

    val str2 = async {
        // this will not be cancelled
        delay(2000)
        "Text2"
    }

    try {
        println(str1.await())
    } catch (e: MyException) {
        println(e)
    }

    println(str2.await())

    // output
    // com.kotlinground.concurrency.coroutines.cancellation.MyException
    // Text2
}