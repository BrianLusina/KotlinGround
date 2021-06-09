package com.kotlinground.strings.firstandlast

fun removeChar(str: String): String {
    return str.substring(1, str.lastIndex)
}