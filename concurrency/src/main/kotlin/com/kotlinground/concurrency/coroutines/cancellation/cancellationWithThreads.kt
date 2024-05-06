package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

fun cpuIntensiveOperations1() {
    Thread.sleep(1000)
}

fun cpuIntensiveOperations2() {
    Thread.sleep(1000)
}

fun cpuIntensiveOperations3() {
    Thread.sleep(1000)
}

suspend fun cpuIntensiveOperations() =
    withContext(Dispatchers.Default) {
        cpuIntensiveOperations1()
        yield()
        cpuIntensiveOperations2()
        yield()
        cpuIntensiveOperations3()
        yield()
    }

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            Thread.sleep(200) // We might have some complex operations or reading files here
            // using the yield function allows suspension and immediately resumes a coroutine. This gives an opportunity
            // to do whatever is needed during suspension or resuming including cancellation or changing a thread using
            // a dispatcher
            yield()
            println("Printing $i")
        }
    }

    // the isActive extension function allows keeping track of a job that is active and stop calculations when it is
    // inactive
    launch(job) {
        do {
            Thread.sleep(200)
            println("Printing")
        } while (isActive)
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
    //Canceled successfully
}