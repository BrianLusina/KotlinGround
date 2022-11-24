package com.kotlinground.design.behavioralpatterns.command

open class Trooper {
    private val orders = mutableListOf<CommandAlias>()

    fun addOrder(order: CommandAlias) {
        orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            val order = orders.removeFirst()
            order()
        }
    }
    // More code here

    fun move(x: Int, y: Int) {
        println("Moving to $x:$y")
    }
}

typealias CommandAlias = () -> Unit

val moveGenerator = fun(
    s: Trooper,
    x: Int,
    y: Int
): CommandAlias {
    return fun() {
        s.move(x, y)
    }
}

fun main() {
    val t = Trooper()

    t.addOrder(moveGenerator(t, 1, 1))
    t.addOrder(moveGenerator(t, 2, 2))
    t.addOrder(moveGenerator(t, 3, 3))

    t.executeOrders()
}