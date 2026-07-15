package com.kotlinground.datastructures.trees.binarytrees.bst

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class BinarySearchTreeInsertTest {

    @Test
    fun `should return tree for inserted data`() {
        val data = intArrayOf(8, 3, 10, 1, 6)
        val searchTree = BinarySearchTree<Int>()

        for (d in data) {
            searchTree.insertTreeNode(d)
        }

        val expectedRoot = BinaryTreeNode(
            data = 8,
            left = BinaryTreeNode(
                data = 3,
                left = BinaryTreeNode(data = 1),
                right = BinaryTreeNode(data = 6)
            ),
            right = BinaryTreeNode(data = 10),
        )

        val actualRoot = searchTree.root()

        assertNotNull(actualRoot)
        assertEquals(expectedRoot, actualRoot)
        assertEquals(expectedRoot.data, actualRoot.data)
        assertEquals(expectedRoot.left?.data, actualRoot.left?.data)
        assertEquals(expectedRoot.right?.data, actualRoot.right?.data)
        assertEquals(expectedRoot.left?.left?.data, actualRoot.left?.left?.data)
        assertEquals(expectedRoot.left?.right?.data, actualRoot.left?.right?.data)
    }
}