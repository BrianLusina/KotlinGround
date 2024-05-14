package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

/**
 * Using semaphores is better than using mutex, but does not help much with shared state. It has the functions acquire,
 * release and withPermit.
 * It allows for setting the number of concurrent requests to a shared state and can be used for rate limiting
 * like below:
 * ```kotlin
 * class LimitedNetworkUserRepository(private val api: UserApi) {
 *  // limited to 10 concurrent requests
 *  private val semaphore = Semaphore(10)
 *
 *  suspend fun requestUser(userId: String) = semaphore.withPermit {
 *      api.requestUser(userId)
 *  }
 * }
 * ```
 */
suspend fun main() = coroutineScope {
    // limited to 2
    val semaphore = Semaphore(2)
    repeat(5) {
        launch {
            semaphore.withPermit {
                delay(1000)
                println(it)
            }
        }
    }
    // ouput:
    // 0
    // 1
    // 3
    // 2
    // 4
}