package com.kotlinground.strings.firstandlast

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveCharsKtTest {

    private fun testSolution(str: String) = str.slice(1..str.length - 2)

    @Test
    fun basicTests() {
        assertEquals("loquen", removeChar("eloquent"))
        assertEquals("ountr", removeChar("country"))
        assertEquals("erso", removeChar("person"))
        assertEquals("lac", removeChar("place"))
        assertEquals("oopss", removeChar("ooopsss"))
    }

    @Test
    fun randomTests() {
        repeat(100) {
            var possible = "abc123"
            var text = ""
            repeat((2..8).random()) {
                text += possible.get((0..possible.length - 1).random())
            }
            assertEquals(testSolution(text), removeChar(text))
        }
    }
}