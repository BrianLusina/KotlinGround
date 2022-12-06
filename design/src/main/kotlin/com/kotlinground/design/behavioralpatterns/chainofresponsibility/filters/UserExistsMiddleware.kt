package com.kotlinground.design.behavioralpatterns.chainofresponsibility.filters

/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
class UserExistsMiddleware(private val server: Server) : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (!server.hasEmail(email)) {
            println("Email $email not registered")
            return false
        }

        if (!server.isValidPassword(email, password)) {
            println("Wrong password")
            return false
        }

        return checkNext(email, password)
    }
}