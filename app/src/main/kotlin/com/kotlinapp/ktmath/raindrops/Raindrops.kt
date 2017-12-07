package com.kotlinapp.ktmath.raindrops

/**
 * @author lusinabrian on 06/12/17.
 */
object Raindrops {
    fun convert(number: Int) : String{
        var output = ""
        (1..number)
                .asSequence()
                .filter { number % it == 0 }
                .forEach {
                    when(it){
                        3 -> output += "Pling"
                        5 -> output += "Plang"
                        7 -> output += "Plong"
                    }
                }
        if (output.isEmpty()){
            output = number.toString()
        }

        return output
    }

    fun convertUsingBuildStr(number: Int) = buildString {
        if (number.hasFactor(3)) append("Pling")
        if (number.hasFactor(5)) append("Plang")
        if (number.hasFactor(7)) append("Plong")
        if (isBlank()) append(number.toString())
    }

    private fun Int.hasFactor(factor : Int) = this.rem(factor) == 0
}