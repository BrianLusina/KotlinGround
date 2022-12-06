package com.kotlinground.design.behavioralpatterns.chainofresponsibility.filters

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val server = Server()
    server.register("admin@example.com", "admin_pass")
    server.register("user@example.com", "user_pass")

    val middleware = Middleware.link(
        ThrottlingMiddleware(2),
        UserExistsMiddleware(server),
        RoleCheckMiddleware()
    )

    server.middleware = middleware
    var success: Boolean
    do {
        println("Enter Email")
        val email = reader.readLine()
        println("Enter Password")
        val password = reader.readLine()
        success = server.login(email, password)
    } while (!success)
}
