package com.kotlinground.concurrency.coroutines.jobs

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    // job created with a builder is active
    val job = Job()
    println(job) //JobImpl{Active}@4cc0edeb

    // until we complete it with a method
    job.complete()
    println(job) //JobImpl{Completed}@4cc0edeb

    val activeJob = launch {
        delay(1000)
    }
    println(activeJob) //StandaloneCoroutine{Active}@5ae63ade

    // we we wait until this job is done
    activeJob.join()
    println(activeJob) //StandaloneCoroutine{Completed}@5ae63ade

    val lazyJob = launch(start = CoroutineStart.LAZY) {
        delay(1000)
    }

    println(lazyJob) // LazyStandaloneCoroutine{New}@11628386

    // it needs to be started to make it active
    lazyJob.start()
    println(lazyJob) //LazyStandaloneCoroutine{Active}@11628386

    lazyJob.join()
    println(lazyJob) //LazyStandaloneCoroutine{Completed}@11628386
}