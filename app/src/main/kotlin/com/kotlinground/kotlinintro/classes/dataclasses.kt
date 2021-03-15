package com.kotlinground.kotlinintro.classes

/**
 * @author lusinabrian on 31/05/17.
 * Data classes are usually used to store data / POJO
 */
fun main() {

    var brian = Student(1, "lusina")
    var lusina = Student(1, "lusina")

    if (brian == lusina) {
        println("Equal")
    } else {
        // we expect this output
        println("Not Equal")
    }

    val sensei1 = Teacher(1, "brian")
    val sensei2 = Teacher(1, "brian")
    if (sensei1 == sensei2) {
        // we expect this output
        println("Equal")
    } else {
        println("Not Equal")
    }

    // allows copying
    var pete = sensei1.copy(name = "Pete Sensei")

    // internally calls toString
    println(pete)
}

// needs to override equal method
class Student(val id: Int, val name: String)

data class Teacher(val id: Int, val name: String)
