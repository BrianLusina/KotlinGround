package com.kotlinground.puzzles.search.binarysearch.mycalendar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class MyCalendarTest {
    @Test
    fun `should return (true, false, true) for MyCalendar()#book(10,20), MyCalendar()#book(15,25), MyCalendar()#book(20,30)`() {
        val myCalendar = MyCalendar()
        assertTrue { myCalendar.book(10, 20) }
        assertFalse { myCalendar.book(15, 25) }
        assertTrue { myCalendar.book(20, 30) }
    }
}
