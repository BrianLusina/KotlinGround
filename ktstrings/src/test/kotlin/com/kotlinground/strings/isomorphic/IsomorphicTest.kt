package com.kotlinground.strings.isomorphic

import kotlin.test.Test
import kotlin.test.assertTrue

class IsomorphicTest {

    @Test
    fun `Should return true for egg & add`() {
        val s = "egg"
        val t = "add"
        assertTrue { isIsomorphicWithMapping(s, t) }
    }
}