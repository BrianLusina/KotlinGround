package com.kotlinground.design.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HashTableTest {

    @Test
    fun `Should add items to HashTable`() {
        val hashTable = HashTable(3)
        hashTable.set(1, "something 1")
        val expectedItem = Item(1, "something 1")
        val actualData = hashTable.get(1)

        Assertions.assertEquals(expectedItem.data, actualData)
    }

    @Test
    fun `Should remove items from HashTable`() {
        val hashTable = HashTable(3)
        hashTable.set(1, "something 1")
        val expectedItem = Item(1, "something 1")

        val actualData = hashTable.get(1)
        Assertions.assertEquals(expectedItem.data, actualData)

        Assertions.assertThrows(Exception::class.java) {
            hashTable.remove(1)
            hashTable.get(1)
        }
    }

    @Test
    fun `Should get items from HashTable`() {
        val hashTable = HashTable(3)
        hashTable.set(1, "something 1")
        val expectedItem = Item(1, "something 1")

        val actualData = hashTable.get(1)
        Assertions.assertEquals(expectedItem.data, actualData)
    }

    @Test
    fun `Should throw exception when key does not exist in HashTable`() {
        val hashTable = HashTable(3)

        Assertions.assertThrows(Exception::class.java) {
            hashTable.remove(1)
            hashTable.get(1)
        }
    }
}