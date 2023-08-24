package com.kotlinground.puzzles.arrays.meetingrooms

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MeetingRoomsTest {
    @Test
    fun `should return 0 from input of A = ()`() {
        val meetings = arrayOf(intArrayOf())
        val expected = 0
        val actual = findMinimumMeetingRooms(meetings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from input of A = ((0, 30),(5, 10),(15, 20))`() {
        val meetings = arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))
        val expected = 2
        val actual = findMinimumMeetingRooms(meetings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of A = ((1, 18), (18, 23), (15, 29), (4, 15), (2, 11), (5, 13))`() {
        val meetings = arrayOf(
            intArrayOf(1, 18),
            intArrayOf(18, 23),
            intArrayOf(15, 29),
            intArrayOf(4, 15),
            intArrayOf(2, 11),
            intArrayOf(5, 13)
        )
        val expected = 4
        val actual = findMinimumMeetingRooms(meetings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 from input of A = () with priority queue`() {
        val meetings = arrayOf(intArrayOf())
        val expected = 0
        val actual = findMinimumMeetingRoomsPriorityQueue(meetings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from input of A = ((0, 30),(5, 10),(15, 20)) with a priority queue`() {
        val meetings = arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))
        val expected = 2
        val actual = findMinimumMeetingRoomsPriorityQueue(meetings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of A = ((1, 18), (18, 23), (15, 29), (4, 15), (2, 11), (5, 13)) with a priority queue`() {
        val meetings = arrayOf(
            intArrayOf(1, 18),
            intArrayOf(18, 23),
            intArrayOf(15, 29),
            intArrayOf(4, 15),
            intArrayOf(2, 11),
            intArrayOf(5, 13)
        )
        val expected = 4
        val actual = findMinimumMeetingRoomsPriorityQueue(meetings)
        assertEquals(expected, actual)
    }
}
