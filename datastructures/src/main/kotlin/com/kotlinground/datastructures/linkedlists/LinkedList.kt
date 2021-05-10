package com.kotlinground.datastructures.linkedlists

abstract class LinkedList<Node> {

    /**
     * Adds a node to the end of the linked list given the data to insert to the node
     */
    abstract fun append(data: Any)

    /**
     * Adds a node to the beginning of the linked list given the data to insert to the node
     */
    abstract fun prepend(data: Any)

    /**
     * Deletes a given node from the LinkedList
     * @param node [Node]
     */
    abstract fun deleteNode(node: Node)

    /**
     * Deletes a given node from the LinkedList given its position
     * @param position [Int]
     */
    abstract fun deleteNodeAtPosition(position: Int)

    /**
     * Deletes a given node from the LinkedList given its data. This will delete the first occurrence of data
     * @param data [Any]
     */
    abstract fun deleteNodeByData(data: Any)

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
    abstract fun detectNodeWithCycle(): Node?

    /**
     * Checks if the linked list has a cycle
     */
    abstract fun hasCycle(): Boolean

    /**
     * Removes cycle from linked list given the head of the linked list
     * @return [Node] head of linked list without cycle
     */
    abstract fun removeCycle(): Node

    /**
     * Reverse a linked list so that the tail becomes the head and the head becomes the tail
     * @param head [Node]
     * @return [Node]
     */
    abstract fun reverse(): Node

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

    /**
     * Alternate split a linked list such that a linked list such as
     * a->b->c->d->e becomes a->c->e->None and b->d->None
     */
    abstract fun alternateSplit(): Pair<Node, Node>

    /**
     * Swaps nodes in a linked list in pairs.
     * As there are different kinds of LinkedLists, it is up to the child class to implement this
     * The premise(idea) is to swap the data of each node with the data of the next node. This is while using
     * an iterative approach
     * Example:
     * 1 -> 2 -> 3 -> 4
     * becomes
     * 2 -> 1 -> 4 -> 3
     * @returns [Node] new head of linked list
     */
    abstract fun pairwiseSwap(): Node?

    /**
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
     * from the end (the list is 1-indexed).
     * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     */
    abstract fun swapNodesAtKthAndKPlusOne(k: Int): Node?
}