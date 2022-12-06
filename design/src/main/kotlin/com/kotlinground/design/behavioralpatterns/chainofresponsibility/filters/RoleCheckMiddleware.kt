package com.kotlinground.design.behavioralpatterns.chainofresponsibility.filters

class RoleCheckMiddleware : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (email == "admin@example.com") {
            println("Hello Admin")
            return true
        }
        println("Hello User")
        return checkNext(email, password)
    }
}
