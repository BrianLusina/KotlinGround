package com.javapp.datastructures.queues;

/**
 * java.java.javapp.datastructures.queues
 * Created by lusinabrian on 06/01/17.
 * Description:
 */
interface QueueInterface <T>{

    /**Adds an element to the queue*/
    void enqueue(T element);

    /**Removes and returns an item in line*/
    T dequeue();

    /**returns an item at the front of the queue, without removing it*/
    T peek();

    /**Checks if the queue is empty*/
    boolean isEmpty();

    /**Checks if the queue is full*/
    boolean isFull();

}
