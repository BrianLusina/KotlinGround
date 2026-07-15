package com.kotlinground.datastructures.hashmap

import java.lang.Exception

/**
 * Describes a HashMap/HashTable with a size. The size will be used to determine where to place items in the HashTable
 * @param size
 */
class HashTable(private val size: Int) {
    private val table: Array<ArrayList<Item>> = Array(size) { arrayListOf() }

    /**
     * Hash function used to calculate a hash based on the key. This will be a modulo operation where the key will be
     * used to create a hash based off of the size of the HashTable(Map). This will be used to add, retrieve or get
     * items from the table
     * @param key
     * @return Integer indicating where to place or retrieve an item given the key.
     */
    private fun hashFunction(key: Int): Int {
        return key % size
    }

    /**
     * Used to add an item to the HashMap/HashTable given it's unique Key and it's value. if the item is already in the
     * HashMap, then an update to its value is performed.
     * @param key: Key used to identify the item
     * @param value: Represents the data of the Item
     */
    fun set(key: Int, value: Any) {
        val hashIndex = hashFunction(key)
        val foundItem = table[hashIndex].firstOrNull { it.key == key }

        if (foundItem != null) {
            foundItem.data = value
        }

        table[hashIndex].add(Item(key, value))
    }

    /**
     * Gets the Item from the HashMap/HashTable given its key if available. Will throw a KeyError if no such key exists
     * @param key: Key to use to retrieve an item from the HashMap
     * @return: Data item of the item
     * @throws Exception KeyError if the key does not exist
     */
    fun get(key: Int): Any {
        val hashIndex = hashFunction(key)
        val foundItem = table[hashIndex].firstOrNull { it.key == key }

        if (foundItem != null) {
            return foundItem.data
        }
        throw Exception("Key $key not found")
    }

    /**
     * Removes an item from the HashMap/HashTable given its key. Raises a Key error if the key does not exist.
     * @param key: key to use to retrieve the item and delete it
     * @throws Exception
     */
    fun remove(key: Int) {
        val hashIndex = hashFunction(key)
        table[hashIndex].forEachIndexed { index, item ->
            if (item.key == key) {
                table[hashIndex].removeAt(index)
            }
        }
        throw Exception("Key $key not found")
    }

}