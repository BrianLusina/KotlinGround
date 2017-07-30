package com.kotlinapp.kotlinintro.ktcollections

/**
 * @author lusinabrian on 08/06/17.
 * small demo of sequences
 */
fun main(args: Array<String>) {
    val meetings = listOf(Meeting(1, Title = "BoardMeeting"), Meeting(id = 2, Title = "Class meeting"))

    val titles: Sequence<String> = meetings
            .asSequence()
            .filter { it.Title.startsWith("B") }
            .map { it.Title }

    for (t in titles) println(t)

}
