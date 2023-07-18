package com.kotlinground.puzzles.hashmap.equalrowsandcolumns


fun equalPairsHashMap(grid: Array<IntArray>): Int {
    var count = 0
    val n = grid.size
    val rowCounter = hashMapOf<String, Int>()

    for (row in grid) {
        val rowString = row.contentToString()
        rowCounter[rowString] = 1 + rowCounter.getOrDefault(rowString, 0)
    }

    for (column in 0 until n) {
        val col = arrayListOf<Int>()

        for (i in 0 until n) {
            col.add(grid[i][column])
        }

        count += rowCounter.getOrDefault(col.toString(), 0)
    }

    return count
}

fun equalPairsBruteForce(grid: Array<IntArray>): Int {
    var count = 0
    val n: Int = grid.size

    // Check each row r against each column c.
    for (r in 0 until n) {
        for (c in 0 until n) {
            var match = true

            // Iterate over row r and column c.
            for (i in 0 until n) {
                if (grid[r][i] != grid[i][c]) {
                    match = false
                    break
                }
            }

            // If row r equals column c, increment count by 1.
            count += if (match) 1 else 0
        }
    }

    return count
}

internal data class TrieNode(var count: Int = 0, val children: HashMap<Int, TrieNode> = hashMapOf())

internal class Trie {
    private var rootTrieNode: TrieNode = TrieNode()

    fun insert(array: IntArray) {
        var trieNode = rootTrieNode
        for (a in array) {
            if (!trieNode.children.containsKey(a)) {
                trieNode.children[a] = TrieNode()
            }
            trieNode = trieNode.children.getOrDefault(a, TrieNode())
        }
        trieNode.count += 1
    }

    fun search(array: IntArray): Int {
        var trieNode = rootTrieNode
        for (a in array) {
            if (trieNode.children.containsKey(a)) {
                trieNode = trieNode.children[a]!!
            } else {
                return 0
            }
        }
        return trieNode.count
    }
}

fun equalPairsTrieNode(grid: Array<IntArray>): Int {
    val trie = Trie()
    var count = 0
    val n: Int = grid.size

    for (row in grid) {
        trie.insert(row)
    }

    for (c in 0 until n) {
        val colArray = IntArray(n)
        for (r in 0 until n) {
            colArray[r] = grid[r][c]
        }
        count += trie.search(colArray)
    }

    return count
}
