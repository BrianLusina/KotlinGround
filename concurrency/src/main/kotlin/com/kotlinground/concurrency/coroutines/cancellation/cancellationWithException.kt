package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun main() = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            repeat(1_000) {
                delay(200)
                println("Printing $it")
            }
        } catch (e: CancellationException) {
            println(e)
            throw e
        } finally {
            println("Finally")
            // this block can run for as long as it needs to clean up resources. However, suspension is not allowed
            println("will always be printed. Use the finally block to cleanup. Close DB connections, file handlers, etc")

            // this is ignored
            launch {
                println("Will not be printed")
            }

            // using withContext(NonCancellable) allows the job to remain in an an active state allowing calling other
            // suspending functions
            withContext(NonCancellable) {
                delay(1000L)
                println("Cleanup done")
            }

            delay(1000) // exception is thrown
            println("Will not be printed")
        }
    }

    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)

    // Output:
    //Printing 0
    //Printing 1
    //Printing 2
    //Printing 3
    //Printing 4
    //kotlinx.coroutines.JobCancellationException: Job was cancelled; job=JobImpl{Cancelling}@4a27ca13
    // Finally
    // will always be printed. Use the finally block to cleanup. Close DB connections, file handlers, etc
    // Cleanup done
    //Cancelled successfully
}