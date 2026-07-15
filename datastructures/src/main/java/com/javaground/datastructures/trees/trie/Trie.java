package com.javaground.datastructures.trees.trie;

/**
 * A Trie is a specialized tree data structure that is used for storing and
 * managing a dynamic set of strings efficiently, particularly for prefix-related operations.
 * The Trie supports operations such as inserting words into the structure,
 * and can be further extended to perform searches or prefix-based queries.
 * The structure consists of nodes (TrieNode) where each node maintains
 * a map of children nodes and a flag to indicate whether it marks the end of a word.
 */
public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
}
