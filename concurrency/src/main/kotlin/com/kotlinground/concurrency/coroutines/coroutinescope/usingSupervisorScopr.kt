package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

/**
 * The [supervisorScope] function also behaves like [coroutineScope]—it creates a [CoroutineScope] that inherits from the
 * outer scope and calls the specified suspend block. The difference is that it overrides the context’s [Job] with
 * [SupervisorJob], so it’s not canceled when a child raises an exception.
 */
fun main() = runBlocking {
    println("Before")
    supervisorScope {
        launch {
            delay(1000)
            throw Error()
        }

        launch {
            delay(2000)
            println("Done")
        }
    }

    println("After")

    // Output
    // Before
    // Exception in thread "main" java.lang.Error
    // Done
    // After

    /**
     * DO NOT USE withContext with SupervisorJob()
     * We may often ask if we can use withContext(SupervisorJob()) instead of [supervisorScope]. No, we can’t. When we
     * use withContext(SupervisorJob()), then [withContext] is still using a regular [Job], and the [SupervisorJob]
     * becomes its
     * parent. As a result, when one child raises an exception, the other children will also be canceled. The
     * [withContext] function will also throw an exception, so its SupervisorJob() is practically useless. This is why
     * we find withContext(SupervisorJob()) pointless and misleading, and we consider it a bad practice.
     */
    println("Before Again")

    withContext(SupervisorJob()) {
        launch {
            delay(1000)
            throw Error()
        }

        launch {
            delay(2000)
            println("Done")
        }
    }

    println("After Again")

    // output
    // Before Again
    // Exception in thread "main" java.lang.Error
}