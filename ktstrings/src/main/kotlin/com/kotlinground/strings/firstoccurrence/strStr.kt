package com.kotlinground.strings.firstoccurrence

fun strStr(haystack: String, needle: String): Int {
    // makes sure we don't iterate through a substring that is shorter than needle
    for (i in 0 until haystack.length - needle.length + 1) {
        // check if any substring of haystack with the same length as needle is equal to needle
        if (haystack.substring(i, i + needle.length) == needle) {
            // if yes, we return the first index of that substring
            return i
        }
    }
    // if we exit the loop, return -1
    return -1
}
