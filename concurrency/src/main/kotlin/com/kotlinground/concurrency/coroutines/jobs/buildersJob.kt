package com.kotlinground.concurrency.coroutines.jobs

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job: Job = launch {
        delay(1000)
        println("Test")
    }

    val deferred: Deferred<String> = async {
        delay(1000)
        "test"
    }

    val anotherJob: Job = deferred

    println(coroutineContext.job.isActive) //true

    val name = CoroutineName("Some name")
    val jobThree = Job()

    launch(name + jobThree) {
        val childName = coroutineContext[CoroutineName]
        println(childName == name) // true
        val childJob = coroutineContext[Job]
        println(childJob == jobThree) // false
        println(childJob == jobThree.children.first()) // true
    }

    val jobFour: Job = launch {
        delay(1000)
    }

    val parentJob: Job = coroutineContext.job
    println(jobFour == parentJob) // false
    val parentChildren: Sequence<Job> = parentJob.children
    println(parentChildren.first() == jobFour) // true

    launch(Job()) {
        delay(1000)
        println("Will not be printed")
    }

    println()
}
