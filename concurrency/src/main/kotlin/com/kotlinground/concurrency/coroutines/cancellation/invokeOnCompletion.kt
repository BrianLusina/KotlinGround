package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = launch {
        delay(1000)
    }

    // this can be used to free resources, The callback function takes in an exception which is nullable. if the exception
    // is null, the job finished with no exception.
    // If the coroutine was cancelled, the throwable is a CancellationException
    // the exception that finished a coroutine.
    // This is called synchronously during cancellation and we do not control the thread in which it will be running
    job.invokeOnCompletion {
        println("Finished")
    }

    delay(400)
    job.cancelAndJoin()
    println("Cancelled successfully")

    // Output:
    //Finished
    //Cancelled successfully
}