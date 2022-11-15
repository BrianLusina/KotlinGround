package com.kotlinground.design.behavioralpatterns.strategy

interface Strategy {
    fun execute(a: Int, b: Int): Int
}

class ConcreteStrategyAdd : Strategy {
    override fun execute(a: Int, b: Int): Int = a + b
}

class ConcreteStrategySubtract : Strategy {
    override fun execute(a: Int, b: Int): Int = a - b
}

class ConcreteStrategyMultiply : Strategy {
    override fun execute(a: Int, b: Int): Int = a * b
}

class Context {
    var currentStrategy: Strategy = ConcreteStrategyAdd()

    fun execute(a: Int, b: Int): Int = currentStrategy.execute(a, b)
}

fun main() {
    val strategyAdd = ConcreteStrategyAdd()
    val strategySubtract = ConcreteStrategySubtract()
    val strategyMultiply = ConcreteStrategyMultiply()

    val context = Context()

    context.currentStrategy = strategyAdd
    val result = context.execute(2, 3)
    println(result)

    context.currentStrategy = strategySubtract
    val anotherResult = context.execute(2, 3)
    println(anotherResult)

    context.currentStrategy = strategyMultiply
    val anotherResult2 = context.execute(2, 3)
    println(anotherResult2)
}
