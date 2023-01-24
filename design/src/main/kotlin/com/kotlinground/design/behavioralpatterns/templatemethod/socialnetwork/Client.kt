package com.kotlinground.design.behavioralpatterns.templatemethod.socialnetwork

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    print("Input user name: ")
    val userName = reader.readLine()
    print("Input password: ")
    val password = reader.readLine()

    print("Input message: ")
    val message = reader.readLine()

    println(
        """
            Choose social network for posting message.
            1 - Facebook
            2 - Twitter
        """.trimIndent()
    )

    val network = when (reader.readLine().toInt()) {
        1 -> Facebook(userName, password)
        2 -> Twitter(userName, password)
        else -> {
            throw RuntimeException("Unknown choice provided")
        }
    }

    network.post(message)
}
