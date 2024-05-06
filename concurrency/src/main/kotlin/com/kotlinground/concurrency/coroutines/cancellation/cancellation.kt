package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = launch {
        repeat(1_000) {
            delay(200)
            println("Printing $it")
        }
    }

    delay(1100)
//    job.cancel()
    // added after to wait for th cancellation to finish. Without this, there would be a race condition
//    job.join()
    // optionally, the above two methods can be removed and replaced with
     job.cancelAndJoin()

    println("Cancelled successfully")

    // output
    //Printing 0
    //Printing 1
    //Printing 2
    //Printing 3
    //Printing 4
    //Cancelled successfully
}