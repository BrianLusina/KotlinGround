package com.kotlinground.concurrency.coroutines.jobs

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = Job()

    launch(job) {// the new job replaces one from parent
        delay(1000)
        println("Text 1")
    }

    launch(job) {// the new job replaces one from parent
        delay(2000)
        println("Text 2")
    }

    job.complete()
    job.join()

    // output
    //    Text 1
    //    Text 2
}