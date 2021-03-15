package com.kotlinground.kotlinintro.javatokotlin

/**
 * @author lusinabrian on 28/05/17.
 */
class Program {

    companion object {
        /**
         * this annotation means that this method is static as far as Java is concerned
         * */
        @JvmStatic
        fun main(args: Array<String>) {
            val person = Person()
            person.name = "Brian"
            person.age = 154

            // this will print out what we expect
            println("${person.name} is ${person.age} years old")

            // throws an exception when setting the name
            // person.name = ""

            // using a try catch helps catch the error
            try {
                person.name = ""
            } catch (e: Exception) {
                println("Error thrown: ${e.message}")
            }

            // partner field has not been set and is null Kotlin will not allow this,
            // since this has been set in Java, Kotlin compiler will not know about this
            // setting, calling partner getter will throw a null value
            println("${person.name}'s partner is ${person.partner}")

            // this will not compile as the name of the person can not be identified as it is
            // NULL, adding the Nullable annotation to the getName of person will tell Kotlin
            // that there is a possibility of this attribute being Null
            // println(person.partner.name)

            // using evlis operator will enable us to still try to access the name of pertner
            println("${person.name}'s partner's name is: ${person.partner?.name}")

        }
    }
}