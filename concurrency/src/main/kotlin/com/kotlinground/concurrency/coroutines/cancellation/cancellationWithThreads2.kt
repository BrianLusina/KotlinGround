package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            Thread.sleep(200) // We might have some complex operations or reading files here
            println("Printing $i")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Canceled successfully")
    delay(1000)

    // Output
    // Printing 0
    //Printing 1
    //Printing 2
    //Printing 3
    //Printing 4
    //Printing 5
    //Printing 6
    //Printing 7
    //Printing 8
    // ... (up to 1000)
}