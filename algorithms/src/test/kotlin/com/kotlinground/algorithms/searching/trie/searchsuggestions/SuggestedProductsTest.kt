package com.kotlinground.algorithms.searching.trie.searchsuggestions

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SuggestedProductsTest {
    @Test
    fun `products = ('mobile', 'mouse', 'moneypot', 'monitor', 'mousepad'), searchWord = 'mouse'`() {
        val products = arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad")
        val searchWord = "mouse"
        val expected = listOf(
            listOf("mobile", "moneypot", "monitor"),
            listOf("mobile", "moneypot", "monitor"),
            listOf("mouse", "mousepad"),
            listOf("mouse", "mousepad"),
            listOf("mouse", "mousepad")
        )

        val actual = suggestedProducts(products, searchWord)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `products = ('havana'), searchWord = 'havana'`() {
        val products = arrayOf("havana")
        val searchWord = "havana"
        val expected = listOf(
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
        )

        val actual = suggestedProducts(products, searchWord)
        assertContentEquals(expected, actual)
    }
}
