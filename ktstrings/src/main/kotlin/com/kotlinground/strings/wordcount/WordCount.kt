package com.kotlinground.strings.wordcount

/**
 * @author lusinabrian on 03/06/17.
 * Counts the number of words in a phrase
 */
object WordCount {
    /**
     * Counts occurrence of each word in the sentence
     * @param sentence a sentence with words
     * @return [Map] with keys with words and values as the counts of numbers
     * */
    fun phrase(sentence: String): Map<String, Int> {
        val phrase = sentence.lowercase().replace(Regex("[^\\w']"), " ").trim()
        val words = phrase.split(Regex("\\s+"))
        val groupedWords = words.groupBy({ w -> w })

        return groupedWords.mapValues({ it.value.size })
    }
}