package com.kotlinground.strings.spreadsheetencode

import kotlin.test.Test
import kotlin.test.assertEquals

class SpreadsheetEncodeTest {

    @Test
    fun `should return 702 for a column ID of ZZ`() {
        val columnID = "ZZ"
        val expected = 702
        val actual = spreadsheetEncodeColumn(columnID)
        assertEquals(expected, actual)
    }
}