package com.javaground.datastructures.linkedlists;

import static com.kotlinground.datastructures.linkedlists.UtilsKt.generateKey;

/**
 * Represents a generic node in a linked list. This abstract class serves
 * as a base class for implementing various types of linked list structures.
 *
 * @param <T> the type of the data stored in the node, which must implement
 *            the Comparable interface to allow comparison operations.
 */
public abstract class LinkedListNode<T extends Comparable<T>> {
    public T data;
    public LinkedListNode<T> next = null;
    String key;

    /**
     * Constructs a new instance of a LinkedListNode with the specified data.
     * The linked list node will contain the given data and a key generated
     * based on the data. The next node reference will be initialized to null.
     *
     * @param data the data to be stored in this linked list node
     */
    public LinkedListNode(T data) {
        this.data = data;
        this.key = generateKey(data);
    }

    /**
     * Constructs a new instance of a LinkedListNode with the specified data and a reference
     * to the next node. The linked list node will contain the given data, a key generated
     * based on the data, and a reference to the next node in the sequence.
     *
     * @param data the data to be stored in this linked list node
     * @param next the reference to the next node in the linked list
     */
    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
        this.key = generateKey(data);
    }

    /**
     * Creates a new instance of a LinkedListNode with the specified data, a reference
     * to the next node, and a custom key.
     *
     * @param data the data to be stored in this linked list node
     * @param next the reference to the next node in the linked list
     * @param key the key associated with this node
     */
    public LinkedListNode(T data, LinkedListNode<T> next, String key) {
        this.data = data;
        this.next = next;
        this.key = key;
    }
}
