package com.kotlinground.datastructures.linkedlists.singly

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class SinglyLinkedListPalindromeTest: FunSpec({
    val testData = listOf(
        intArrayOf(2, 4, 6, 4, 2) to true,
        intArrayOf(0, 3, 5, 5, 0) to false,
        intArrayOf(9, 7, 4, 4, 7, 9) to true,
        intArrayOf(1,2,3,2,1) to true,
        intArrayOf(4,7,9,5,4) to false,
        intArrayOf(2,3,5,5,3,2) to true,
        intArrayOf(6,1,0,5,1,6) to false,
        intArrayOf(3,6,9,8,4,8,9,6,3) to true,
    )

    context("Using a Stack data structure") {
        withData(testData) { (data, expected) ->
            val singlyLinkedList = SinglyLinkedList<Int>()

            for (d in data) {
                singlyLinkedList.append(d)
            }

            val actual = singlyLinkedList.isPalindrome()
            actual shouldBe expected
        }
    }

    context("Using Floyd's Hare and Tortoise Algorithm") {
        withData(testData) { (data, expected) ->
            val singlyLinkedList = SinglyLinkedList<Int>()

            for (d in data) {
                singlyLinkedList.append(d)
            }

            val actual = singlyLinkedList.isPalindromeTwoPointers()
            actual shouldBe expected
        }
    }
})