package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * coroutineScope blocks the parent scope until the passed in function completes execution and cancels itself. It
 * inherits the coroutineContext from the parent(outer scope) and overrides the context's Job, thus the produced scope
 * respects its parental responsibilities
 * - Inherits a context from its parent.
 * - Waits for all its children before it can finish itself.
 * - Cancels all its children when the parent is canceled.
 */
fun main() = runBlocking(CoroutineName("Parent")) {
    val a = coroutineScope {
        delay(1000)
        10
    }
    println("a is calculated")

    val b = coroutineScope {
        delay(1000)
        20
    }
    println("b is calculated")

    println(a)
    println(b)

    // In the example below, we can observe that “After” will be printed at the end because coroutineScope will not
    // finish until all its children are finished. Furthermore, CoroutineName is appropriately passed from parent to child.

    println("Before")
    longTask()
    println("After")

    // In the following snippet, we can observe how cancellation works. A canceled parent leads to the cancellation of
    // unfinished children.

    val job = launch(CoroutineName("Another Parent")) {
        longTask()
    }

    delay(1500)
    job.cancel()

    // output
    // a is calculated
    // b is calculated
    // 10
    // 20
    // Before
    // [Parent] Finished task 1
    // [Parent] Finished task 2
    // After
    // [Another Parent] Finished task 1
}

suspend fun longTask() = coroutineScope {
    launch {
        delay(1000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 1")
    }

    launch {
        delay(2000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 2")
    }
}
