package com.kotlinground.puzzles.scrabblescore

/**
 * @author lusinabrian on 04/12/17.
 */
object ScrabbleScore {

    private fun scoreMap(letter: Char) = when (letter) {
        'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
        'D', 'G' -> 2
        'B', 'C', 'M', 'P' -> 3
        'F', 'H', 'V', 'W', 'Y' -> 4
        'K' -> 5
        'J', 'X' -> 8
        'Q', 'Z' -> 10
        else -> 0
    }

    private val scoreMap = mapOf(
            arrayListOf("A", "E", "I", "O", "U", "L", "N", "R", "S", "T") to 1,
            arrayListOf("D", "G") to 2,
            arrayListOf("B", "C", "M", "P") to 3,
            arrayListOf("F", "H", "V", "W", "Y") to 4,
            arrayListOf("K") to 5,
            arrayListOf("J", "X") to 8,
            arrayListOf("Q", "Z") to 10
    )

    fun scoreWord(word: String): Int {
        var total = 0
        val letters = word.toUpperCase().split("")

        scoreMap.forEach { arrList, score ->
            letters.filter { arrList.contains(it) }
                    .forEach { total += score }
        }
        // return the total
        return total
    }

    val scoreWord = { word: String -> word.toUpperCase().map { scoreMap(it) }.sum() }
}
