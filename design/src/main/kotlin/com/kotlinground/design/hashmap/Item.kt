package com.kotlinground.design.hashmap

/**
 * Describes item stored in the HashMap
 * @param key Unique key of item
 * @param data Data stored in Item
 */
data class Item(
    val key: Int,
    var data: Any
)
