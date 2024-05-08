package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun CoroutineScope.log(text: String) {
    val name = this.coroutineContext[CoroutineName]?.name
    println("[$name] $text")
}

/**
 * The withContext function is similar to coroutineScope, but it allows us to make some changes to the scope.
 * The context provided as an argument to this function overrides the context from the parent scope
 * (the same as in coroutine builders). This means that withContext (EmptyCoroutineContext) and coroutineScope()
 * behave in exactly the same way.
 *
 * We often use the function withContext to set a different coroutine scope for part of our code. Usually, it is best
 * if we used it together with dispatchers,
 */
fun main() = runBlocking(CoroutineName("Parent")) {
    log("Before") // [Parent] Before

    withContext(CoroutineName("Child 1")) {
        delay(1000)
        log("Hello 1") // [Child 1] Hello 1
    }

    withContext(CoroutineName("Child 2")) {
        delay(1000)
        log("Hello 2") // [Child 2] Hello 2
    }

    log("After") // [Parent] After

    // output
    // [Parent] Before
    // [Child 1] Hello 1
    // [Child 2] Hello 2
    // [Parent] After

}
