package com.javapp.datastructures.stacks;

/**
 * java.java.javapp.datastructures.stacks
 * Created by lusinabrian on 26/12/16.
 * Description: Stack interface
 */
interface StackInterface <T>{

    /**
     * Push an element on to the stack*/
     void push(T t);

     /**
      * Remove the top most element and return it
      * This should reduce the size of the Stack and move the next element to the top*/
     T pop();

     /**
      * Return the top most element in the stack*/
     T peek();

     /**Gets the current size of the stack
      * and returns it*/
     int getCurrentSize();

     /**
      * Check if stack is full*/
     boolean isFull();

     /**
      * Check is stack is empty*/
     boolean isEmpty();
}
