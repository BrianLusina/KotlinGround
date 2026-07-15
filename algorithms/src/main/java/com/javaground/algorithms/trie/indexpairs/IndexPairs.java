package com.javaground.algorithms.trie.indexpairs;

import com.javaground.datastructures.trees.trie.Trie;
import com.javaground.datastructures.trees.trie.TrieNode;

import java.util.ArrayList;

public class IndexPairs {
    public static int[][] of(String text, String[] words) {
        // Initialize a Trie data structure to store the words
        Trie trie = new Trie();

        // Insert each word into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        ArrayList<int[]> resultList = new ArrayList<>();

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            // Start from the root of the Trie for each character in the text
            TrieNode node = trie.root;

            // Check each possible substring starting from index i
            for (int j = i; j < text.length(); j++) {
                char ch = text.charAt(j);
                // If the character is not in the current Trie node's children, stop searching
                if (!node.children.containsKey(ch)) {
                    break;
                }

                // Move to the next node (character) in the Trie
                node = node.children.get(ch);

                // If we reach the end of a word, record the indices
                if (node.isEnd) {
                    resultList.add(new int[]{i, j});
                }
            }
        }

        // Convert ArrayList<int[]> to int[][]
        int[][] output = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            output[i] = resultList.get(i);
        }

        // Return the list of index pairs representing matched words
        return output;
    }
}
