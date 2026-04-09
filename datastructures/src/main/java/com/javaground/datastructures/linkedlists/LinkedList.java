package com.javaground.datastructures.linkedlists;

/**
 * Represents an abstract implementation of a generic linked list data structure.
 * This class serves as a base for creating custom linked lists where each node
 * is represented by an instance of a subclass of {@link LinkedListNode}.
 *
 * @param <T> the type of elements stored in the linked list, which must implement
 *            the Comparable interface to enable comparison operations.
 * @param <Node> the type of nodes used in the linked list, which must extend
 *               {@link LinkedListNode}.
 */
public abstract class LinkedList<T extends Comparable<T>, Node extends LinkedListNode<T>> implements Iterable<Node> {

    /**
     * Appends the specified data to the end of the linked list. This method
     * creates a new node containing the given data and links it at the
     * end of the current list.
     *
     * @param data the data to be appended to the linked list
     */
    abstract public void append(T data);

    /**
     * Removes and returns the last node from the linked list. If the list
     * is empty, this method may return null or throw an exception based on the
     * specific implementation of the linked list.
     *
     * @return the last node in the linked list, or null if the list is empty
     */
    abstract public Node pop();
}
