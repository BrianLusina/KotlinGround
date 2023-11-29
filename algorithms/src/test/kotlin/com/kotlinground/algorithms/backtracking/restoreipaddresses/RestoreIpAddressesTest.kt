package com.kotlinground.algorithms.backtracking.restoreipaddresses

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RestoreIpAddressesTest {
    @Test
    fun `should return ('255_255_11_135','255_255_111_35') from 25525511135`() {
        val s = "25525511135"
        val expected = listOf("255.255.11.135", "255.255.111.35")
        val actual = restoreIpAddresses(s)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return ('0_0_0_0') from 0000`() {
        val s = "0000"
        val expected = listOf("0.0.0.0")
        val actual = restoreIpAddresses(s)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return ('1_0_10_23','1_0_102_3','10_1_0_23','10_10_2_3', '101_0_2_3') from 101023`() {
        val s = "101023"
        val expected = listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")
        val actual = restoreIpAddresses(s)
        assertEquals(expected, actual)
    }
}
