package com.kotlinapp.kotlinintro.twofer

/**
 * @author lusinabrian on 21/11/17.
 */

fun twofer(vararg name: String) : String = "One for ${if(name.isEmpty()) "you" else name[0]}, one for me."