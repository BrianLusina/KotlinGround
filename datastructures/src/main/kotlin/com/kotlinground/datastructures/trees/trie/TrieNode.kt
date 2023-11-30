package com.kotlinground.datastructures.trees.trie

/**
 * TrieNode represents a node in a Trie
 * @param children [HashMap] is a hashmap of character to node
 * @param char [Char] the character at this node
 * @param isEnd [Boolean] whether this the end of a word
 */
data class TrieNode(
    val char: Char,
    val children: HashMap<Char, TrieNode> = hashMapOf(),
    var isEnd: Boolean = false
)
