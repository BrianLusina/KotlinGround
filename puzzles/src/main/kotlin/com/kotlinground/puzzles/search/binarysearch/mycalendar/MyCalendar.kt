package com.kotlinground.puzzles.search.binarysearch.mycalendar

import java.util.TreeMap

class MyCalendar(private val calendar: TreeMap<Int, Int> = TreeMap()) {

    /**
     * Checks if it is possible to book an event into a calendar given a start and end time.
     *
     * A potential insertion index idx means that the booking at calendar[idx-1] must come before the new booking,
     * and the booking at calendar[idx] must come after the new booking. To simplify the searching process, we can
     * deduce that calendar[idx-1] has a start time earlier than start, and calendar[idx] has a later start time than
     * start. Essentially, we are trying to find the leftmost entry such that the start time of this booking is greater
     *  than the start of the new booking. We have the feasible function calendar[idx][0] > start, if this condition is
     * true, we will recurse the left half, otherwise, recurse the right half.
     *
     * To implement the booking behaviour, we will use binary search to find a potential insertion index, then check
     * whether the new booking can be actually scheduled into our calendar by checking whether the new booking overlaps
     *  with calendar[idx-1] and calendar[idx].
     *
     * Complexity: n is the number of events booked
     * - Time Complexity: O(nlog(n)). For each new event, we search that the event is legal in O(log(n)) time then insert
     * in O(log(n)) time.
     *
     * - Space Complexity: O(n), the size of the structure used
     * @param start [Int] start time of event
     * @param end [Int] end time of event
     * @return [Boolean] True if the event can be inserted and that it is, False otherwise.
     */
    fun book(start: Int, end: Int): Boolean {
        val previous = calendar.floorKey(start)
        val next = calendar.ceilingKey(start)

        if ((previous == null || calendar[previous]!! <= start) && (next == null || end <= next)) {
            calendar[start] = end
            return true
        }

        return false
    }
}
