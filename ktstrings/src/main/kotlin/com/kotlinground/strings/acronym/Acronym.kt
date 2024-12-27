package com.kotlinground.strings.acronym

import java.util.regex.Pattern

/**
 * @author lusinabrian on 01/12/17.
 */
object Acronym {

    fun generate(phrase : String) : String {
        // split the phrase by non characters
        val words = phrase.split(Pattern.compile("\\W+"))
        val acronym = StringBuilder()

        // for each word
        words.forEach { acronym.append(it[0].uppercaseChar()) }

        return acronym.toString()
    }
}