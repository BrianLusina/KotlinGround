package com.kotlinapp.kotlinintro

import hello
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

/**
 * @author lusinabrian on 20/05/17.
 */
class HelloWorldTest {
    @Test
    fun helloNoName() {
        assertEquals("Hello, World!", hello())
    }

    @Test
    fun helloSampleName() {
        assertEquals("Hello, Alice!", hello("Alice"))
    }

    @Test
    fun helloBlankName() {
        assertEquals("Hello, World!", hello("    "))
    }

    @Test
    fun helloAnotherSampleName() {
        assertEquals("Hello, Bob!", hello("Bob"))
    }
}