package com.kotlinground.design.structuralpatterns.decorators

interface StarTrekRepository {
    operator fun get(name: String): String
    operator fun set(ship: String, name: String)
}

class StarTrekRepositoryImpl : StarTrekRepository {
    private val captains = mutableMapOf("USS" to "Picard")

    override fun get(name: String): String = captains[name] ?: "Unknown"

    override fun set(ship: String, name: String) {
        captains[ship] = name
    }
}

class LoggingStarTrekRepo(private val repo: StarTrekRepository) : StarTrekRepository by repo {
    override fun get(name: String): String {
        println("Getting captain for $name")
        return repo[name]
    }
}

val starTrekRepo = StarTrekRepositoryImpl()
val withLogging = LoggingStarTrekRepo(starTrekRepo)

fun main() {
    withLogging["USS"]
}
