package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.runBlocking

var counter = 0

fun main() = runBlocking {
    massiveRun {
        counter++
    }
    println(counter) // 506961
}
