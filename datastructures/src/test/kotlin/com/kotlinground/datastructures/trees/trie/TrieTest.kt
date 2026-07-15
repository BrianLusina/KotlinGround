package com.kotlinground.datastructures.trees.trie

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TrieTest {

    @Test
    fun `insert a word into the trie`() {
        val word = "can"
        val trie = Trie()
        trie.insert(word)

        val actual = trie.search("can")
        val expected = listOf("can")
        assertContentEquals(expected, actual)
    }

    @Test
    fun `collect all words should return all words in the Trie`() {
        val trie = Trie()

        val wordList = listOf("can", "cat")
        wordList.forEach { trie.insert(it) }

        val actual = trie.collectAllWords()

        assertContentEquals(wordList, actual)
    }
}
