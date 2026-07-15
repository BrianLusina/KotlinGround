package com.kotlinground.datastructures.trees.binarytrees.threaded

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ThreadedBinarySearchTreeTest {
    companion object {
        @JvmStatic
        fun inorderTraversalTestCases() = listOf(
            Arguments.of(
                listOf(4, 2, 6, 1, 3, 5, 7),
                listOf(1, 2, 3, 4, 5, 6, 7)
            )
        )

        @JvmStatic
        fun reverseInorderTraversalTestCases() = listOf(
            Arguments.of(
                listOf(4, 2, 6, 1, 3, 5, 7),
                listOf(7, 6, 5, 4, 3, 2, 1)
            )
        )
    }

    @ParameterizedTest(name = "{index} => ThreadedBinarySearchTree.inorderTraversal({1}) should return {2}")
    @MethodSource("inorderTraversalTestCases")
    fun `inorder traversal`(data: List<Int>, expected: List<Int>) {
        val threadedBinarySearchTree = ThreadedBinarySearchTree<Int>()
        data.forEach { threadedBinarySearchTree.insertTreeNode(it) }
        assertEquals(expected, threadedBinarySearchTree.inorderTraversal())
    }

    @ParameterizedTest(name = "{index} => ThreadedBinarySearchTree.reverseInorderTraversal({1}) should return {2}")
    @MethodSource("reverseInorderTraversalTestCases")
    fun `reverse inorder traversal`(data: List<Int>, expected: List<Int>) {
        val threadedBinarySearchTree = ThreadedBinarySearchTree<Int>()
        data.forEach { threadedBinarySearchTree.insertTreeNode(it) }
        assertEquals(expected, threadedBinarySearchTree.reverseInorderTraversal())
    }
}
