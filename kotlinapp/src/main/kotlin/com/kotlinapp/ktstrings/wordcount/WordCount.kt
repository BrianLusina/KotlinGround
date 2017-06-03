package com.kotlinapp.ktstrings.wordcount

/**
 * @author lusinabrian on 03/06/17.
 * Counts the number of words in a phrase
 */
object WordCount{
    /**
     * Counts occurrence of each word in the sentence
     * @param sentence a sentence with words
     * @return [Map] with keys with words and values as the counts of numbers
     * */
    fun phrase(sentence: String): Map<String, Int>{
        var result : Map<String, Int> = mapOf()
        sentence.split(" ").forEach {
            if(it !in result.keys){
                result.plus(it to it.count())
            }
        }
        return result
    }
}