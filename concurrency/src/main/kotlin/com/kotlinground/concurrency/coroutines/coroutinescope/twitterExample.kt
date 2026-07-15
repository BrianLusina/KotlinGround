package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

data class Details(val name: String, val followers: Int)
data class Tweet(val text: String)

class ApiException(
    val code: Int,
    message: String
) : Throwable(message)

fun getFollowersNumber(): Int = throw ApiException(500, "Service unavailable")

suspend fun getUserName(): String {
    delay(500)
    return "someusername"
}

suspend fun getTweets(): List<Tweet> {
    return listOf(Tweet("Hello, world"))
}

suspend fun getUserDetails(): Details = coroutineScope {
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    Details(userName.await(), followersNumber.await())
}

fun main() = runBlocking {
    /**
     * OR
     * ```kotlin
     * val details = try {
     *  getUserDetails()
     * } catch(e: ApiException) {
     *  println("Failed with error: $it")
     *  null
     * }
     * ```
     */
    val details = runCatching {
        getUserDetails()
    }
        .getOrElse {
            println("Failed with error: $it")
            null
        }

    val tweets = async {
        getTweets()
    }
    println("User: $details")
    println("Tweets: ${tweets.await()}")

    // output
    // Failed with error: com.kotlinground.concurrency.coroutines.coroutinescope.ApiException: Service unavailable
    // User: null
    // Tweets: [Tweet(text=Hello, world)]
}
