package com.kotlinground.datastructures.trees.trie

/**
 * A class representing a Trie data structure. A Trie is a tree-like structure used for storing strings,
 * usually to efficiently support prefix-based search operations.
 *
 * This implementation provides methods for inserting words, searching for words with a specific prefix,
 * and collecting all words stored in the Trie.
 */
class Trie(var root: TrieNode = TrieNode()) {

    fun insert(word: String) {
        val trimmedWord = word.trim()
        var currentNode = root

        for (char in trimmedWord) {
            // if the current node has a child key with the current character
            if (currentNode.children.containsKey(char)) {
                // follow the child node
                currentNode = currentNode.children[char]!!
            } else {
                // if the current character is not found among the children, we add the character as a new child node
                val newNode = TrieNode()
                currentNode.children[char] = newNode

                // follow this new node
                currentNode = newNode
            }
        }

        // after inserting the entire word into the trie, mark the node as the end
        currentNode.isEnd = true
    }

    /**
     * Searches for a word in the trie, returning a collection of words that match it
     * @param word [String] word to search for
     * @return [Collection] matching words
     */
    fun search(word: String): Collection<String> {
        var currentNode = root

        for (char in word) {
            if (currentNode.children.containsKey(char)) {
                currentNode = currentNode.children[char]!!
            } else {
                return emptyList()
            }
        }

        val result = arrayListOf<String>()

        fun dfs(currentNode: TrieNode, prefix: String) {
            if (currentNode.isEnd) {
                result.add(prefix + currentNode)
            }

            for ((char, node) in currentNode.children) {
                dfs(node, prefix + char)
            }
        }

        dfs(currentNode, word.substring(0, word.length - 1))
        return result
    }


    /**
     * Collect all words from the trie
     */
    fun collectAllWords(): Collection<String> {
        val words = arrayListOf<String>()

        fun collectAllWordsHelper(currentNode: TrieNode, word: String) {
            for ((char, node) in currentNode.children) {
                if (node.isEnd) {
                    words.add(word)
                } else {
                    collectAllWordsHelper(node, word + char)
                }
            }
        }

        collectAllWordsHelper(root, "")
        return words
    }
}
