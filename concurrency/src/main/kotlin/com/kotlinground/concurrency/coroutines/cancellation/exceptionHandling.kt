package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {// cancelled
    launch {// this will be canceled by the coroutine that throws an error

        // wrapping in a try catch will not prevent the cancellation on exception
        try {
            launch {
                delay(1000)
                throw Error("Some error") // will cancel this coroutine
            }
        } catch (e: Throwable) {
            println("Will not be printed")
        }

        launch {// will be cancelled by the parent
            delay(2000)
            println("Will not be printed")
        }

        launch {// will be cancelled by the parent
            delay(500) // faster than the exception
            println("Will be printed")
        }
    }

    launch {// separate coroutine but will be cancelled as the parent is cancelled
        delay(2000)
        println("Will not be printed")
    }

    // output
    // Will be printed
    //Exception in thread "main" java.lang.Error: Some error
}