package com.kotlinground.design.creationalpatterns.factory.notification

fun main() {
    val notification = NotificationFactory.create("email")
    notification?.send("test")
}