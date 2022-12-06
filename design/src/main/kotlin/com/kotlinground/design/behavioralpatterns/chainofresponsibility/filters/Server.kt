package com.kotlinground.design.behavioralpatterns.chainofresponsibility.filters

class Server {
    private val users = hashMapOf<String, String>()
    lateinit var middleware: Middleware

    fun login(email: String, password: String): Boolean {
        if (middleware.check(email, password)) {
            println("Authorization have been successfully")
            return true
        }
        return false
    }

    fun register(email: String, password: String) {
        users[email] = password
    }

    fun hasEmail(email: String): Boolean = users.containsKey(email)

    fun isValidPassword(email: String, password: String): Boolean = users[email].equals(password)
}
