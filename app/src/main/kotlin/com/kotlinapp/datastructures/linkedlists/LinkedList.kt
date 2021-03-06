package com.kotlinapp.datastructures.linkedlists

abstract class LinkedList<Node> {

    /**
     * Adds a node to the end of the linked list given the data to insert to the node
     */
    abstract fun push(data: Any)

    /**
     * Searches for a node in the provided linked list
     * @param node
     */
    abstract fun search(node: Node): Node


    /**
     * Counts the number of occurrences of data in a linked list
     * @param data
     */
    abstract fun count(data: Any): Int

    /**
     * Gets the last node in the LinkedList
     */
    abstract fun getLast(): Node

    /**
     * Deletes the first node in the linked list and returns it
     */
    abstract fun deleteFirst(): Node?

    /**
     * Removes the last node in the linked list
     */
    abstract fun removeLast(): Node?

    /**
     * Returns true is the linked list is empty, false otherwise
     */
    abstract fun isEmpty(): Boolean

    /**
     * Detects node that has a cycle
     */
    abstract fun detectNodeWithCycle(head: Node?): Node?

    /**
     * Checks if the linked list has a cycle
     */
    abstract fun hasCycle(head: Node): Boolean

    /**
     * Removes cycle from linked list given the head of the linked list
     * @param head [Node]
     * @return [Node] head of linked list without cycle
     */
    abstract fun removeCycle(head: Node): Node

    /**
     * Reverse a linked list so that the tail becomes the head and the head becomes the tail
     * @param head [Node]
     * @return [Node]
     */
    abstract fun reverse(head: Node): Node

    /**
     * Inserts a node at the specified position of the linked list
     * @param node
     * @param position [Int]
     * @return [Node]
     */
    abstract fun insert(node: Node, position: Int): Node

    /**
     * Inserts a node after the currently provided node. This is not necessarily the head of the linked list
     * @param nodeToInsert [Node]
     * @param currentNode [Node]
     * @return [Node]
     */
    abstract fun insertAfter(nodeToInsert: Node, currentNode: Node): Node
}