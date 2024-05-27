package com.kotlinground.datastructures.linkedlists

import java.security.MessageDigest

/**
 * Generates a key given the data item
 */
fun <T> generateKey(data: T): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(data.toString().toByteArray())
    return digest.toString()
}