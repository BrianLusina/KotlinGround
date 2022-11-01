package com.kotlinground.design.creationalpatterns.singleton

object Logger {
    init {
        println("Logger initialized")
    }

    fun info(message: String) {
        println("[INFO] $message")
    }
}
