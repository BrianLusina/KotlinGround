package com.kotlinground.design.creationalpatterns.factory.parser

fun property(prop: String): Property {
    val (name, value) = prop.split(":")

    return when (name) {
        "port" -> IntProperty(name, value.trim().toInt())
        "environment" -> StringProperty(name, value.trim())
        else -> throw Exception("Unknown property $name")
    }
}
