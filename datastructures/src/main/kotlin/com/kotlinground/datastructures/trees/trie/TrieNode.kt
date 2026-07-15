package com.kotlinground.datastructures.trees.trie

/**
 * TrieNode represents a node in a Trie
 * @param children [HashMap] is a hashmap of character to node
 * @param isEnd [Boolean] whether this the end of a word
 */
data class TrieNode(
    val children: HashMap<Char, TrieNode> = hashMapOf(),
    var isEnd: Boolean = false
)
