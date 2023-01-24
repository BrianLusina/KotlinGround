package com.kotlinground.design.behavioralpatterns.templatemethod.socialnetwork

/**
 * Base class of a Social Network
 */
abstract class Network {
    open lateinit var username: String
    open lateinit var password: String

    fun post(message: String): Boolean {
        if (login(username, password)) {
            val result = sendData(message.toByteArray())
            logout()
            return result
        }
        return false
    }

    abstract fun login(username: String, password: String): Boolean
    abstract fun sendData(data: ByteArray): Boolean
    abstract fun logout()
}
