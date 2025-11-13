package com.kotlinground.datastructures.trees.binarytrees.bst

import com.kotlinground.datastructures.trees.TreeNode
import com.kotlinground.datastructures.trees.Tree
import com.kotlinground.datastructures.trees.binarytrees.BinaryTree
import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode

class BinarySearchTree<T : Comparable<T>>(private var root: BinaryTreeNode<T>? = null) : BinaryTree<T>() {

    private operator fun Any.plusAssign(i: Int) {
        this += i
    }

    fun root(): BinaryTreeNode<T>? {
        return root
    }

    companion object {
        /**
         * Constructs a balanced binary search tree from a sorted list of comparable elements.
         *
         * @param values A sorted list of comparable elements used to construct the binary search tree.
         * @return A `BinarySearchTree` constructed from the given sorted list of values, or `null` if the list is empty.
         */
        fun <T: Comparable<T>> constructTree(values: List<T>): BinarySearchTree<T>? {
            if (values.isEmpty()) {
                return null
            }

            fun constructTreeHelper(left: Int, right: Int): BinaryTreeNode<T>? {
                if (left > right) {
                    return null
                }

                val mid = (left + right) / 2
                val node = BinaryTreeNode(values[mid])
                node.left = constructTreeHelper(left, mid - 1)
                node.right = constructTreeHelper(mid + 1, right)
                return node
            }
            val root = constructTreeHelper(0, values.size - 1)
            return BinarySearchTree(root)
        }
    }

    override fun height(): Int {
        if (root == null) {
            return 0
        }

        fun heightHelper(node: BinaryTreeNode<T>?): Int {
            if (node == null) {
                return 0
            }
            return maxOf(heightHelper(node.left), heightHelper(node.right)) + 1
        }

        return heightHelper(root)
    }

    /**
     * Inserts a Tree node into this Binary Search Tree
     */
    override fun insertTreeNode(data: T): BinaryTreeNode<T>? {
        if (this.root == null) {
            this.root = BinaryTreeNode(data)
            return this.root
        }

        fun insertHelper(value: T, node: BinaryTreeNode<T>?): BinaryTreeNode<T> {
            if (node == null) {
                return BinaryTreeNode(value)
            }

            if (value < node.data) {
                node.left = insertHelper(value, node.left)
            } else {
                node.right = insertHelper(value, node.right)
            }
            return node
        }

        insertHelper(data, this.root)
        return this.root
    }

    override fun delete(data: T): BinaryTreeNode<T>? {
        if (root == null) {
            return null
        }

        fun lift(node: BinaryTreeNode<T>?, nodeToDelete: BinaryTreeNode<T>): BinaryTreeNode<T>? {
            if (node == null) {
                return null
            }

            // if the current node of this function has a left child, we recursively call this function to continue down
            // the left subtree to find the successor node
            return if (node.left != null) {
                node.left = lift(node.left, nodeToDelete)
                node
            } else {
                // if the current node has no left child, that means the current node of this function is the successor
                // node therefore we take its value and make it the new value of the node that we are deleting.
                nodeToDelete.data = node.data
                // we return the successor node's right child to be now used as its parent's left child
                node.right
            }
        }

        fun deleteHelper(value: T, node: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
            // base case when we have hit the bottom of the tree, and the parent node has no children
            if (node == null) {
                return null
            }
            // if the value to delete is less than or greater than the current node, we set the left or right child
            // respectively to be the return value of a recursive call of this very method on the current node's left or
            // right subtree
            else if (value < node.data) {
                node.left = deleteHelper(value, node.left)
                // we return the current node (and its subtree if existent) to be used as the new value of its parent's
                // left or right child
                return node
            } else if (value > node.data) {
                node.right = deleteHelper(value, node.right)
                return node
                // if the current node is the one we want to delete
            } else {
                // if the current node has no left child, we delete it by returning it's right child (and it's subtree if
                // existent) to be its parent's new subtree
                return if (node.left == null) {
                    node.right
                    // if the node has no left nor right child, this ends up being None as per the first line of code in
                    // this function
                } else if (node.right == null) {
                    node.left
                } else {
                    // if the current node has 2 children, we delete the current node by calling the lift function,
                    // which changes the current node's value to the value of its successor node
                    node.right = lift(node.right, node)
                    node
                }
            }
        }

        return deleteHelper(data, root)
    }

    override fun mergeTree(otherTree: TreeNode<T>?): TreeNode<T>? {

        fun mergeTreeHelper(root: BinaryTreeNode<T>?, otherTreeRoot: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
            val thisRoot = root ?: this.root ?: return otherTreeRoot

            if (otherTreeRoot == null) {
                return root
            }

            // assumption is that data is an integer
            thisRoot.data?.plusAssign(otherTreeRoot.data as Int)
            thisRoot.left = mergeTreeHelper(thisRoot.left, otherTreeRoot.left)
            thisRoot.right = mergeTreeHelper(thisRoot.right, otherTreeRoot.right)

            return root
        }

        return mergeTreeHelper(this.root, otherTree as BinaryTreeNode<T>)
    }

    override fun inorderTraversalIteratively(): Collection<T> {
        val stack = arrayListOf<BinaryTreeNode<T>>()
        val result = arrayListOf<T>()
        var current = root;

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            result.add(current.data)
            current = current.right
        }

        return result
    }

    override fun inorderMorrisTraversal(): Collection<T> {
        val result = arrayListOf<T>()
        var current = root
        var pre: BinaryTreeNode<T>?

        while (current != null) {
            if (current.left == null) {
                result.add(current.data)
                current = current.right
            }

            pre = current?.left

            while (pre?.right != null) {
                pre = pre.right
            }

            pre?.right = current
            val temp = current
            current = current?.left
            temp?.left = null
        }
        return result
    }

    override fun preorderTraversal(): Collection<T> {
        val result = arrayListOf<T>()
        val stack = arrayListOf<BinaryTreeNode<T>>()

        if (root == null) {
            return result
        }

        var current = root

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                result.add(current.data)
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            current = current.right
        }

        return result
    }

    override fun postorderTraversal(): Collection<T> {
        val values = arrayListOf<T>()
        val stackOne = arrayListOf<BinaryTreeNode<T>>()
        val stackTwo = arrayListOf<BinaryTreeNode<T>>()

        if (root == null) {
            return values
        }

        stackOne.add(root!!)

        while (stackOne.size != 0) {
            val node = stackOne.removeAt(stackOne.size - 1)
            stackTwo.add(node)

            if (node.left != null) {
                stackOne.add(node.left!!)
            }

            if (node.right != null) {
                stackOne.add(node.right!!)
            }
        }

        while (stackTwo.size != 0) {
            val node = stackTwo.removeAt(stackTwo.size - 1)
            values.add(node.data)
        }

        return values
    }

    /**
     * Checks if the binary search tree is valid.
     *
     * @return true if the binary search tree is valid or empty; false otherwise.
     */
    fun isValid(): Boolean {
        if (root == null) {
            return true
        }

        val stack = arrayListOf(Triple(root?.left, root, root?.right))
        while (stack.isNotEmpty()) {
            val (lowerBound, node, upperBound) = stack.removeFirst()
            if (node == null) {
                continue
            }

            if (node.data <= lowerBound!!.data || node.data >= upperBound!!.data) {
                return false
            }

            if (lowerBound != null) {
                stack.add(Triple(lowerBound, node.left, node))
            }

            if (upperBound != null) {
                stack.add(Triple(node, node.right, upperBound))
            }
        }

        return true
    }

    /**
     * LowestCommonAncestor returns the LCA of 2 nodes
     * Considering it is a BST, we can assume that this tree is a valid BST, we could also check for this
     * If both of the values in the 2 nodes provided are greater than the root node, then we move to the right.
     * if the nodes are less than the root node, we move to the left.
     * If there is no root node, then we exit and return Null, as no common ancestor could exist in such a case with
     * no root node.
     * Assumptions:
     * - assumes that the node itself can also be an ancestor/descendant of itself
     * Complexity Analysis:
     * Time Complexity: O(h).
     * The Time Complexity of the above solution is O(h), where h is the height of the tree.
     * Space Complexity: O(1).
     * The space complexity of the above solution is constant.
     */
    override fun lowestCommonAncestor(nodeOne: TreeNode<T>, nodeTwo: TreeNode<T>): TreeNode<T>? {
        if (root == null) {
            return null
        }

        if (root!!.data == nodeOne.data || root!!.data == nodeTwo.data) {
            return root
        }

        while (root != null) {
            root = if (root!!.data!! > nodeOne.data && root!!.data!! > nodeTwo.data) {
                root!!.left
            } else if (root!!.data!! < nodeOne.data && root!!.data!! < nodeTwo.data) {
                root!!.right
            } else {
                break
            }
        }

        return root
    }

    override fun leafSimilar(other: Tree<T>): Boolean {
        other as BinarySearchTree<T>
        if ((root == null && other.root != null) || (other.root == null && root != null)) {
            return false
        }

        val leaves1 = arrayListOf<T>()
        val leaves2 = arrayListOf<T>()

        fun dfs(node: BinaryTreeNode<T>?, leafValues: ArrayList<T>) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    leafValues.add(node.data)
                }
                dfs(node.left, leafValues)
                dfs(node.right, leafValues)
            }
        }

        dfs(root, leaves1)
        dfs(other.root, leaves2)

        return leaves1.equals(leaves2)
    }
}
