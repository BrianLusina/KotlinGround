package com.kotlinground.puzzles.bouncing

import kotlin.test.Test
import kotlin.test.assertEquals

class BouncingBallTest {
    @Test
    fun test1() {
        assertEquals(3, bouncingBall(3.0, 0.66, 1.5))
    }

    @Test
    fun test2() {
        assertEquals(15, bouncingBall(30.0, 0.66, 1.5))
    }

    @Test
    fun test3() {
        assertEquals(21, bouncingBall(30.0, 0.75, 1.5))
    }

    @Test
    fun test4() {
        assertEquals(3, bouncingBall(30.0, 0.4, 10.0))
    }

    @Test
    fun test5() {
        assertEquals(3, bouncingBall(40.0, 0.4, 10.0))
    }

    @Test
    fun test6() {
        assertEquals(-1, bouncingBall(10.0, 0.6, 10.0))
    }

    @Test
    fun test7() {
        assertEquals(-1, bouncingBall(40.0, 1.0, 10.0))
    }

    @Test
    fun test8() {
        assertEquals(-1, bouncingBall(-5.0, 0.66, 1.5))
    }

    @Test
    fun test9() {
        assertEquals(-1, bouncingBall(5.0, -1.0, 1.5))
    }
}