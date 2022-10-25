/**
 * Demonstrates how to create abstract factory methods
 */
package com.kotlinground.design.creationalpatterns.factory

interface Property {
    val name: String
    val value: Any
}

interface ServerConfig {
    val properties: List<Property>
}

data class IntProperty(
    override val name: String,
    override val value: Int
) : Property

data class StringProperty(
    override val name: String,
    override val value: String
) : Property

data class ServerConfigImpl(
    override val properties: List<Property>
) : ServerConfig

fun property(prop: String): Property {
    val (name, value) = prop.split(":")

    return when (name) {
        "port" -> IntProperty(name, value.trim().toInt())
        "environment" -> StringProperty(name, value.trim())
        else -> throw Exception("Unknown property $name")
    }
}


interface Parser {
    fun property(prop: String): Property
    fun server(props: List<String>): ServerConfig
}

class YamlParser : Parser {
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(props: List<String>): ServerConfig {
        TODO("Not yet implemented")
    }
}

class JsonParser : Parser {
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(props: List<String>): ServerConfig {
        TODO("Not yet implemented")
    }
}

val portProperty = property("port: 8080")
val environmentProperty = property("environment: production")
