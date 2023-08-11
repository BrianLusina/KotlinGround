package com.kotlinground.datastructures.linkedlists

interface LinkedList<Node, T> {
    /**
     * Adds a node to the end of the linked list given the data to insert to the node
     */
    fun append(data: T)

    fun headNode(): Node?

    /**
     * Removes last node in the linked list and returns it. Depending on the type of linked list used, this will have
     * different Time Complexities:
     * DoublyLinkedList with a tail reference or tail field will result in an O(1) operation as there will be no need
     * to traverse the enter linked list to remove the last node and update the pointers
     * DoubleLinkedList with no tail reference or field and SinglyLinkedList will have an O(n) operation where n is the
     * number of nodes in the list as the algorithm has to traverse the entire list before removing the last node in the
     * list
     */
    fun pop(): T?

    /**
     * Remove value at front
     */
    fun shift(): T?

    /**
     * Adds a node to the beginning of the linked list given the data to insert to the node
     */
    fun prepend(data: T)

    /**
     * Deletes a given node from the LinkedList
     * @param node [Node]
     */
    fun deleteNode(node: Node)

    /**
     * Deletes a given node from the LinkedList given its position
     * @param position [Int]
     */
    fun deleteNodeAtPosition(position: Int)

    /**
     * Deletes a given node from the LinkedList given its data. This will delete the first occurrence of data
     * @param data [Any]
     */
    fun deleteNodeByData(data: T)

    /**
     * Deletes all given node from the LinkedList given its data.
     * @param data [Any]
     */
    fun deleteNodesByData(data: T): Node?

    /**
     * Deletes and returns the middle node of a linked list
     * @return [Node]
     */
    fun deleteMiddle(): Node?

    /**
     * Finds the middle node in a linked list
     * @return [Node] Middle node
     */
    fun findMiddleNode(): Node?

    /**
     * Searches for a node in the provided linked list
     * @param node
     */
    fun search(node: Node): Node


    /**
     * Counts the number of occurrences of data in a linked list
     * @param data
     */
    fun count(data: T): Int

    /**
     * Gets the last node in the LinkedList
     */
    fun getLast(): Node

    /**
     * Deletes the first node in the linked list and returns it
     */
    fun deleteFirst(): Node?

    /**
     * Removes the last node in the linked list
     */
    fun removeLast(): Node?

    /**
     * Returns true is the linked list is empty, false otherwise
     */
    fun isEmpty(): Boolean

    /**
     * Detects node that has a cycle
     */
    fun detectNodeWithCycle(): Node?

    /**
     * Checks if the linked list has a cycle
     */
    fun hasCycle(): Boolean

    /**
     * Removes cycle from linked list given the head of the linked list
     * @return [Node] head of linked list without cycle
     */
    fun removeCycle(): Node

    /**
     * Reverse a linked list so that the tail becomes the head and the head becomes the tail
     * @return [Node]
     */
    fun reverse()

    /**
     * Inserts a node at the specified position of the linked list
     * @param node
     * @param position [Int]
     * @return [Node]
     */
    fun insert(node: Node, position: Int): Node

    /**
     * Inserts a node after the currently provided node. This is not necessarily the head of the linked list
     * @param nodeToInsert [Node]
     * @param currentNode [Node]
     * @return [Node]
     */
    fun insertAfter(nodeToInsert: Node, currentNode: Node): Node

    /**
     * Alternate split a linked list such that a linked list such as
     * a->b->c->d->e becomes a->c->e->None and b->d->None
     */
    fun alternateSplit(): Pair<Node, Node>

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
    fun pairwiseSwap(): Node?

    /**
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
     * from the end (the list is 1-indexed).
     * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     */
    fun swapNodesAtKthAndKPlusOne(k: Int): Node?

    /**
     * Swaps two nodes based on the data they contain. We search through the LinkedList looking for the data item in
     * each node. Once the first is found, we keep track of it and move on until we find the next data item. Once that
     * is found, we swap the two nodes' data items.
     * If we can't find the first data item nor the second. No need to perform swap. If the 2 data items are similar
     * no need to perform swap as well.
     * If the LinkedList is empty (i.e. has no head node), return, no need to swap when we have no LinkedList :)
     */
    fun swapNodes(dataOne: T, dataTwo: T)

    /**
     * Returns the number of nodes in the linked list
     */
    fun size(): Int

    fun oddEvenList(): Node?
}