package com.kotlinapp.algorithms.etl

/**
 * @author lusinabrian on 31/05/17.
 */
class ETL{
    companion object{
        /**
         * Maps the old data to a new system
         * */
        fun transform(oldMap : Map<Int, List<Char>>) : Map<Char, Int>{
            var result : HashMap<Char, Int> = HashMap()
            for((k, v) in oldMap){
                for (char in v){
                    result.put(char.toLowerCase(), k)
                }
            }
            return result
        }
    }
}
