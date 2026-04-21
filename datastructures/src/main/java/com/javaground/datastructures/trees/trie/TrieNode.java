package com.javaground.datastructures.trees.trie;

import java.util.HashMap;

/**
 * Represents a single node in a Trie data structure.
 * A TrieNode stores a flag to denote the end of a word
 * and keeps track of its children nodes using a map.
 */
public class TrieNode {
    public boolean isEnd;
    public HashMap<Character, TrieNode> children;

    public TrieNode() {
        this.isEnd = false;
        this.children  = new HashMap<>();
    }
}
