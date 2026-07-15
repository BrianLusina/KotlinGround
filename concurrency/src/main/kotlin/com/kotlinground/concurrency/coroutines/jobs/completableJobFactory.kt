package com.kotlinground.concurrency.coroutines.jobs

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = Job()

    launch(job) {// the new job replaces one from parent
        repeat(5) {
            delay(200)
            println("Rep$it")
        }
    }

    launch {
        delay(500)
        job.complete()
    }

    job.join()

    launch(job) {// the new job replaces one from parent
        println("Will not be printed")
    }

    println("Done")

    // output
    //    Rep0
    //    Rep1
    //    Rep2
    //    Rep3
    //    Rep4
    //    Done
}