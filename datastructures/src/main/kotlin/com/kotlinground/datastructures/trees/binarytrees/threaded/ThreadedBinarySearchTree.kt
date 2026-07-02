package com.kotlinground.datastructures.trees.binarytrees.threaded

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode
import com.kotlinground.datastructures.trees.binarytrees.bst.BinarySearchTree

/**
 * A threaded binary search tree (TBST) implementation that extends the functionality
 * of a standard binary search tree. This type of tree uses threading to optimize
 * traversal operations by utilizing unused child pointers to point to in-order
 * predecessor or successor nodes.
 *
 * This implementation supports the insertion of elements, along with in-order and
 * reverse in-order traversal using the threading mechanism without requiring a stack
 * or recursion.
 *
 * @param T The type of data stored in the nodes of the tree. The type must implement
 * the [Comparable] interface to support ordering.
 * @constructor Initializes the tree with an optional root node.
 */
class ThreadedBinarySearchTree<T : Comparable<T>>(private var root: BinaryTreeNode<T>? = null) : BinarySearchTree<T>()  {
    override fun insertTreeNode(data: T): BinaryTreeNode<T>? {
        val r = root
        if (r == null) {
            root = BinaryTreeNode(data)
            return root
        }

        var current = r
        while (true) {
            if (data == current?.data) return current // no duplicates

            if (data < current?.data!!) {
                val left = current.left
                if (!current.leftThread!! && left != null) {
                    current = left
                    continue
                }
                val newNode = BinaryTreeNode(data)
                newNode.left = current.left        // inherit cur's predecessor
                newNode.leftThread = true
                newNode.right = current             // cur is the new successor
                newNode.rightThread = true
                current.left = newNode
                current.leftThread = false
                return root
            } else {
                val right = current.right
                if (!current.rightThread!! && right != null) {
                    current = right
                    continue
                }
                val newNode = BinaryTreeNode(data)
                newNode.right = current.right       // inherit cur's successor
                newNode.rightThread = true
                newNode.left = current               // cur is the new predecessor
                newNode.leftThread = true
                current.right = newNode
                current.rightThread = false
                return root
            }
        }
    }
    
    private fun leftmost(start: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
        var node = start ?: return null
        while (!node.leftThread && node.left != null) {
            node = node.left!!
        }
        return node
    }

    private fun rightmost(start: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
        var node = start ?: return null
        while (!node.rightThread && node.right != null) {
            node = node.right!!
        }
        return node
    }

    fun successor(node: BinaryTreeNode<T>): BinaryTreeNode<T>? =
        if (node.rightThread) node.right else leftmost(node.right)

    fun predecessor(node: BinaryTreeNode<T>): BinaryTreeNode<T>? =
        if (node.leftThread) node.left else rightmost(node.left)

    /** Iterative inorder traversal using threads only - no stack needed. */
    override fun inorderTraversal(): Collection<T> {
        val result = mutableListOf<T>()
        var cur = leftmost(root)
        while (cur != null) {
            result.add(cur.data)
            cur = successor(cur)
        }
        return result
    }

    /** Same idea, walking predecessor threads right-to-left. */
    fun reverseInorderTraversal(): Collection<T> {
        val result = mutableListOf<T>()
        var cur = rightmost(root)
        while (cur != null) {
            result.add(cur.data)
            cur = predecessor(cur)
        }
        return result
    }
}
