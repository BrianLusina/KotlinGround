package com.kotlinground.concurrency.coroutines.dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * One can switch between using the Default Dispatcher and the IO dispatcher. However, the thread is the same with the
 * only difference being the limits. The limits between Default and IO are independent of each other, therefore there
 * is not starvation experienced while switching coroutine scopes with different dispatchers
 */
suspend fun main() = coroutineScope {
    launch(Dispatchers.Default) {
        println(Thread.currentThread().name)
        // this is useful when calling blocking functions from libraries, essentially making them suspending functions
        withContext(Dispatchers.IO) {
            println(Thread.currentThread().name)
        }
    }

    println("Done")

    // Output:
    // Done
    //DefaultDispatcher-worker-1
    //DefaultDispatcher-worker-1
}
