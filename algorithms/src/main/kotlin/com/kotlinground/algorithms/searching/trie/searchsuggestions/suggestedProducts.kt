package com.kotlinground.algorithms.searching.trie.searchsuggestions

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

/**
 * Since the question asks for the result in a sorted order, let's start with sorting products.
 * An advantage that comes with sorting is Binary Search, we can binary search for the prefix. Once we locate the first
 * match of prefix, all we need to do is to add the next 3 words into the result (if there are any), since we sorted the
 * words beforehand.
 * Complexity Analysis
 *
 * Time complexity: O(nlog(n)) + O(mlog(n)). Where n is the length of products and m is the length of the search word.
 * Here we treat string comparison in sorting as O(1). O(nlog(n)) comes from the sorting and O(mlog(n)) comes from
 * running binary search on products m times.
 *
 * In Java there is an additional complexity of O(m^2) due to Strings being immutable, here m is the length of searchWord.
 *
 * Space complexity : Varies between O(1) and O(n) where n is the length of products, as it depends on the implementation
 * used for sorting. We ignore the space required for output as it does not affect the algorithm's space complexity.
 *
 * Space required for output is O(m) where m is the length of the search word.
 */
fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    Arrays.sort(products)

    val result = arrayListOf<ArrayList<String>>()

    var start: Int
    var bsStart = 0
    val numberOfProducts = products.size

    fun lowerBound(items: Array<String>, startIdx: Int, word: String): Int {
        var left = startIdx
        var right = items.size
        while (left < right) {
            val mid = (right + left) / 2
            if (items[mid] >= word) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    var prefix = ""
    for (char in searchWord.toCharArray()) {
        prefix += char

        // Get the starting index of word starting with `prefix`.
        start = lowerBound(products, bsStart, prefix)

        // Add empty vector to result.
        result.add(ArrayList())

        // Add the words with the same prefix to the result.
        // Loop runs until `i` reaches the end of input or 3 times or till the
        // prefix is same for `products[i]` Whichever comes first.
        for (i in start until min(start + 3, numberOfProducts)) {
            if (products[i].length < prefix.length || products[i].substring(0, prefix.length) != prefix) break
            result[result.size - 1].add(products[i])
        }

        // Reduce the size of elements to binary search on since we know
        bsStart = abs(start.toDouble()).toInt()
    }
    return result
}
