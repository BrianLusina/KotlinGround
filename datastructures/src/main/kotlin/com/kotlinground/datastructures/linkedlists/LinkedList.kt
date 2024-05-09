package com.kotlinground.datastructures.linkedlists

abstract class LinkedList<Node, T> {
    /**
     * Adds a node to the end of the linked list given the data to insert to the node
     */
    abstract fun append(data: T)

    abstract fun headNode(): Node?

    /**
     * Removes last node in the linked list and returns it. Depending on the type of linked list used, this will have
     * different Time Complexities:
     * DoublyLinkedList with a tail reference or tail field will result in an O(1) operation as there will be no need
     * to traverse the enter linked list to remove the last node and update the pointers
     * DoubleLinkedList with no tail reference or field and SinglyLinkedList will have an O(n) operation where n is the
     * number of nodes in the list as the algorithm has to traverse the entire list before removing the last node in the
     * list
     */
    abstract fun pop(): T?

    /**
     * Remove value at front
     */
    abstract fun shift(): T?

    /**
     * Adds a node to the beginning of the linked list given the data to insert to the node
     */
    abstract fun prepend(data: T)

    /**
     * Deletes a given node from the LinkedList
     * @param node [Node]
     */
    abstract fun deleteNode(node: Node)

    /**
     * Deletes a given node from the LinkedList given its position
     * @param position [Int]
     */
    abstract fun deleteNodeAtPosition(position: Int): Node?

    /**
     * Deletes a given node from the LinkedList given its data. This will delete the first occurrence of data
     * @param data [Any]
     */
    abstract fun deleteNodeByData(data: T)

    /**
     * Deletes all given node from the LinkedList given its data.
     * @param data [Any]
     */
    abstract fun deleteNodesByData(data: T): Node?

    /**
     * Deletes and returns the middle node of a linked list
     * @return [Node]
     */
    abstract fun deleteMiddle(): Node?

    /**
     * Finds the middle node in a linked list
     * @return [Node] Middle node
     */
    abstract fun findMiddleNode(): Node?

    /**
     * Searches for a node in the provided linked list
     * @param node
     */
    abstract fun search(node: Node): Node


    /**
     * Counts the number of occurrences of a data in a LinkedList. If the linked list is empty(no head). 0 is returned.
     * otherwise the occurrences of the data element will be sought using the equality operator. This assumes that the
     * data element in each node already implements this operator
     *
     * Complexity:
     * The assumption here is that n is the number of nodes in the linked
     *
     * Time O(n): This is because the algorithm iterates through each node in the linked list to find data values in
     * each node that equal the provided data argument in the abstract function. This is both for the worst and best case as
     * each node in the linked list has to be checked
     *
     * Space O(1): no extra space is required other than the value being incremented for each node whose data element
     * equals the provided data argument.
     * @param data [T] data to count.
     * @return [Int] number of occurrences
     */
    abstract fun countOccurrences(data: T): Int

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
     * Removes duplicates from the linked list
     */
    abstract fun removeDuplicates(): Node?

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
     * @return [Node]
     */
    abstract fun reverse()

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

    /**
     * Swaps two nodes based on the data they contain. We search through the LinkedList looking for the data item in
     * each node. Once the first is found, we keep track of it and move on until we find the next data item. Once that
     * is found, we swap the two nodes' data items.
     * If we can't find the first data item nor the second. No need to perform swap. If the 2 data items are similar
     * no need to perform swap as well.
     * If the LinkedList is empty (i.e. has no head node), return, no need to swap when we have no LinkedList :)
     */
    abstract fun swapNodes(dataOne: T, dataTwo: T)

    /**
     * Returns the number of nodes in the linked list
     */
    abstract fun size(): Int

    abstract fun oddEvenList(): Node?

    /**
     * Inserts a given data item after the given node
     */
    abstract fun insertAfter(node: Node, data: T)

    /**
     * Retrieves the nth to the last node
     * If n is less than 0, an error must be raised
     */
    abstract fun nthToLastNode(n: Int): Node?

    /**
     * Rotate a linked list by k where k is the position of the pivot node to rotate the linked list by
     */
    abstract fun rotate(k: Int): Node?

    /**
     * Checks if a linked list is a palindrome
     */
    abstract fun isPalindrome(): Boolean

    /**
     * Moves the tail node of a linked list to the head node
     * Moves the tail node to the head node making the tail node the new head of the linked list
     * Uses two pointers where last pointer will be moved until it points to the last node in the linked list.
     * The second pointer, previous, will point to the second last node in the linked list.
     *
     * Complexity Analysis:
     *
     * An assumption is made where n is the number of nodes in the linked list
     * - Time: O(n) as the pointers have to be moved through each node in the linked list until both point to the
     * last and second last nodes in the linked list
     *
     * - Space O(1) as no extra space is incurred in the iteration. Only pointers are moved at the end to move the tail
     * node to the head and make the second to last node the new tail     *
     */
    abstract fun moveTailToHead()
}

