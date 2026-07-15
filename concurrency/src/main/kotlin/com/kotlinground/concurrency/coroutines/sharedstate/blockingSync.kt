package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.runBlocking

var counter2 = 0

fun main() = runBlocking {
    val lock = Any()
    massiveRun {
        synchronized(lock) { // blocking threads. suspending functions can not be used in this block
            counter2++
        }
    }
    println("Counter = $counter2") //Counter = 1000000
}
