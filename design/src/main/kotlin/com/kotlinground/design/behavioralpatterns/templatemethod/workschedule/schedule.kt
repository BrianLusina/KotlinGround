package com.kotlinground.design.behavioralpatterns.templatemethod.workschedule

fun runSchedule(beforeLunch: () -> Unit, afterLunch: () -> Unit, bossHook: (() -> Unit)? = fun() { println() }) {
    fun arriveToWork() {
        println("How are y'all doing?")
    }

    val drinkCoffee = { println("Did someone leave the milk out?") }

    fun goToLunch() = println("I would like some Italian food please")

    val goHome = fun() {
        println("Finally, some well deserved rest")
    }

    arriveToWork()
    drinkCoffee()
    beforeLunch()
    goToLunch()
    afterLunch()
    bossHook?.let { it() }
    goHome()
}

fun main() {
    runSchedule(
        afterLunch = fun() {
            println("Discuss my lunch with boss' secretary")
            println("Read something not related to work")
        },
        beforeLunch = {
            println("Look for my next trip destination")
            println("Read Stackoverflow")
        },
        bossHook = { println("Boss: Can we talk privately?") }
    )
}
