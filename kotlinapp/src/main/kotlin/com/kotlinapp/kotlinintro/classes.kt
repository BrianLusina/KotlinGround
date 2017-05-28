package com.kotlinapp.kotlinintro

/**
 * @author lusinabrian on 28/05/17.
 * Simple demo on classes in Kotlin
 */

/** super class with primary constructor, which will be subclassed
 * open key word allows for this class to be inherited
 * */
open class Animal(val name: String) {

    // this will be called when the animal instance is first created
    init {
        println("Animal created with name: $name")
    }

    // secondary constructor
    constructor(name: String, habitat: String) : this(name) {
        println("$name lives in $habitat")
    }

    /**
     * Returns the sound an animal can make
     * open annotation means this method can be overridden*/
    open fun makeSound(sound: String): String{
        return sound
    }

    /**
     * This class member belongs to Animal class and can not be overridden
     * */
    fun modeOfMovement(){

    }
}

/**
 * class inheriting from Animal
 * */
open class Mammal(name: String) : Animal(name){

    // property declaration
    open val hasFur = true

    constructor(name: String, noOfLegs: Int) : this(name){
        println("Mammal $name created with $noOfLegs legs")
    }

    override fun makeSound(sound: String): String {
        return "$sound !!!"
    }

    open fun canMove() : Boolean{
        return true
    }
}

/**
 * Person class, which is obviously a mammal*/
class Person(name: String, age: Int) : Mammal(name){

    // overriding property declaration
    override val hasFur: Boolean = false

    init {
        println("Person $name created, age: $age years old")
    }

    /**
     * final annotation means that this class member/method can not be overridden by
     * subclasses*/
    final override fun canMove(): Boolean {
        return super.canMove()
    }
}


fun main(args: Array<String>) {
    // creates an instance of animal class
    val Cat = Mammal("Micky", 4)
    println(Cat.makeSound("Meow"))
}

