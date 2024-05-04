package com.kotlinground.concurrency.coroutines.jobs

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Test 1")
    }

    launch {
        delay(2000)
        println("Test 2")
    }

    val children = coroutineContext[Job]?.children
    val childrenNum = children?.count()
    println("Number of children: $childrenNum")
    children?.forEach { it.join() }

    println("All tests done")

    // output
    // Number of children: 2
    //Test 1
    //Test 2
    //All tests done
}
