package com.kotlinapp.kotlinintro.spektesting

import java.util.zip.CheckedOutputStream

/**
 * @author lusinabrian on 28/05/17.
 */

class Calculator (val output: Result){
}

interface Result{
    fun write(answer: Int)
}