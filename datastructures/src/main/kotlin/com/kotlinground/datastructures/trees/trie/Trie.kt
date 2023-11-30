package com.kotlinground.datastructures.trees.trie

/**
 * Trie is a trie tree
 */
class Trie(private var root: TrieNode) {

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
                result.add(prefix + currentNode.char)
            }

            for ((char, node) in currentNode.children) {
                dfs(node, prefix + char.toString())
            }
        }

        dfs(currentNode, word.substring(0, word.length - 1))
        return result
    }

    fun insert(word: String) {
        var currentNode = root

        for (char in word) {
            // if the current node has a child key with the current character
            if (currentNode.children.containsKey(char)) {
                // follow the child node
                currentNode = currentNode.children[char]!!
            } else {
                // if the current character is not found among the children, we add the character as a new child node
                val newNode = TrieNode(char)
                currentNode.children[char] = newNode

                // follow this new node
                currentNode = newNode
            }
        }

        // after inserting the entire word into the trie, mark the node as the end
        currentNode.isEnd = true
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
