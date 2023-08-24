package com.kotlinground.puzzles.arrays.meetingrooms

import java.util.*

/**
 * Uses 2 lists to find the minimum number of meeting rooms required
 *
 * Complexity:
 * Time Complexity: O(n*log(n)) as we sort the 2 lists
 * Space Complexity: O(n) we store the meetings in a list
 *
 * @param meetings: start and end times of meetings
 * @return: minimum number of meeting rooms to allocated
 */
fun findMinimumMeetingRooms(meetings: Array<IntArray>): Int {
    if (meetings.isEmpty()) {
        return 0
    }

    val startTimes = arrayListOf<Int>()
    val endTimes = arrayListOf<Int>()

    for (meeting in meetings) {
        startTimes.add(meeting[0])
        endTimes.add(meeting[1])
    }

    startTimes.sort()
    endTimes.sort()

    var j = 0
    var numRooms = 0

    for (i in 0 until startTimes.size) {
        if (startTimes[i] < endTimes[j]) {
            numRooms++
        } else {
            j++
        }
    }

    return numRooms
}

/**
 *  Uses a priority queue to find minimum number of meetings
 *
 *  Complexity:
 *  Time Complexity: O(log(n)) as we sort the list
 *  Space Complexity: O(n) we store the meetings in a list
 *
 *  @param meetings: start and end times of meetings
 *  @return: minimum number of meeting rooms to allocated
 */
fun findMinimumMeetingRoomsPriorityQueue(meetings: Array<IntArray>): Int {
    if (meetings.isEmpty()) {
        return 0
    }

    Arrays.sort(meetings) { a, b -> a[0] - b[0] }

    val rooms = PriorityQueue<Int>()
    rooms.add(meetings[0][1])

    for (i in 1 until meetings.size) {
        val start = meetings[i][0]
        val end = meetings[i][1]

        // if earliest ending meeting ends before the next meeting starts, remove it from the heap
        if (rooms.peek() <= start) {
            rooms.poll()
        }

        rooms.add(end)
    }

    return rooms.size
}
