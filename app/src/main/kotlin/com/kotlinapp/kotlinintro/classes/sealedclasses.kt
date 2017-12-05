package com.kotlinapp.kotlinintro.classes

/**
 * @author lusinabrian on 31/05/17.
 * Sealed classes are used to define the hierachy of a class and limit the number of classes
 * to derive from it. These classes are abstract and are very useful when one needs to control
 * the number of derived classes they want to have
 * Sealed classes are abstract
 */

sealed class PersonEvent {
    class Awake : PersonEvent()
    class Sleep : PersonEvent()
    class Eat(val food: String) : PersonEvent()
}

fun handlePersonEvent(e: PersonEvent) {
    when (e) {
        is PersonEvent.Awake -> println("Awake")
        is PersonEvent.Sleep -> println("sleep")
        is PersonEvent.Eat -> println("eat")
    }
}

fun main(args: Array<String>) {
    // handlePersonEvent()
}