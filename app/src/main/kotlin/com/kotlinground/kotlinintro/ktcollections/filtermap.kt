package com.kotlinground.kotlinintro.ktcollections

/**
 * @author lusinabrian on 08/06/17.
 * demo of filter map in Kotlin
 */

fun main() {
    val meetings = listOf(Meeting(1, Title = "BoardMeeting"), Meeting(id = 2, Title = "Class meeting"))

    val titles = meetings
            .filter { it.Title.startsWith("B") }
            .map { it.Title }

    for (t in titles) println(t)


}

class Meeting(val id: Int, val Title: String) {
    val people = listOf(Person("Sam"), Person("Brian"))
}

data class Person(val name: String)