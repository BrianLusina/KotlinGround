package com.javaground.datastructures.stack;

public abstract class Stack<T> implements Iterable<T> {
    public abstract void push(T item);
    public abstract T pop();
    public abstract T peek();
    public abstract Integer size();
    public abstract Boolean isEmpty();
}
