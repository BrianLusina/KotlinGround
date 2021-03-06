package com.kotlinground.strings.rnatranscription

/**
 * @author lusinabrian on 29/05/17.
 */
fun transcribeToRna(dna: String): String = dna.map {
    when (it) {
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        else -> it
    }
}.joinToString("")
