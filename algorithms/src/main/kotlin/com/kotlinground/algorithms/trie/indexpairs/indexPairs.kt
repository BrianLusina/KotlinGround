package com.kotlinground.algorithms.trie.indexpairs

import com.kotlinground.datastructures.trees.trie.Trie

/**
 * Finds all index pairs [i, j] such that the substring `text[i .. j]` is present in the provided list of words.
 * The index pairs are returned in lexicographically sorted order, first by the value of `i` and then by the value of `j`.
 *
 * @param text the input string in which the substrings are to be searched
 * @param words a list of strings representing the words to be searched in the text
 * @return a list of pairs (i, j) where each pair represents the start and end indices of a substring in the text that
 * matches a word in the list
 */
fun indexPairs(text: String, words: List<String>): List<Pair<Int, Int>> {
    // Initialize the trie
    val trie = Trie()

    // for each word insert into the trie
    words.forEach { trie.insert(it) }

    val result = mutableListOf<Pair<Int, Int>>()

    // Loop through each character in the text
    for (i in text.indices) {
        // Start from the root of the Trie for each character in the text
        var node = trie.root

        // For each possible substring starting from index i
        for (j in i until text.length) {
            val ch = text[j]
            // If the character is not in the current Trie nodes' children, stop searching
            if (!node.children.containsKey(ch)) {
                break
            }

            // Move to the next node(character) in the Trie
            node = node.children.getValue(ch)

            if (node.isEnd) {
                result.add(Pair(i, j))
            }
        }
    }

    return result
}
