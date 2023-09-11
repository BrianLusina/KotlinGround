package com.kotlinground.puzzles.graph.canvisitallrooms

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanVisitAllRoomsTest {
    @Test
    fun `should return true for rooms=((1),(2),(3),())`() {
        val rooms = listOf(listOf(1), listOf(2), listOf(3), listOf())
        val actual = canVisitAllRooms(rooms)
        assertTrue(actual)
    }

    @Test
    fun `should return False for ((1,3), (3,0,1), (2), (0))`() {
        val rooms = listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))
        val actual = canVisitAllRooms(rooms)
        assertFalse(actual)
    }

    @Test
    fun `should return True for ((2,3),(), (2), (1,3))`() {
        val rooms = listOf(listOf(2, 3), listOf(), listOf(2), listOf(1, 3))
        val actual = canVisitAllRooms(rooms)
        assertTrue(actual)
    }
}