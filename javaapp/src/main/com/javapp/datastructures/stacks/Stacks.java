package com.javapp.datastructures.stacks;

import java.util.ArrayList;

/**
 * java.java.javapp.datastructures.stacks
 * Created by lusinabrian on 26/12/16.
 * Description:
 */
public class Stacks<T> implements StackInterface<T>{
    private int maxSize;
    private ArrayList<T> stack;

    public Stacks(){}

    /**
     * Initializes a new Stack object with max size
     * @param maxSize the maximum size this stack will take*/
    public Stacks(int maxSize){
        this.maxSize = maxSize;
        this.stack = new ArrayList<>(maxSize);
    }

    /**Check if the stack is full then push the item into the Stack if not full
     * */
    @Override
    public void push(T t) {
        if(this.isFull()){
            throw new StackOverflowError("Stack size exceeded");
        }
        if(this.isEmpty()){
            stack.add(t);
        }else if(!this.isEmpty() && !this.isFull()){
            stack.add(t);
        }
    }

    @Override
    public T pop() {
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("Stack is Empty");
        }else{
            T top = this.peek();
            stack.remove(this.peek());
            return top;
        }
    }

    @Override
    public T peek() {
        return stack.get(getCurrentSize() - 1);
    }

    @Override
    public int getCurrentSize() {
        return getStack().size();
    }

    @Override
    public boolean isFull() {
        return getCurrentSize() == getMaxSize();
    }

    @Override
    public boolean isEmpty() {
        return getStack().isEmpty();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    ArrayList<T> getStack() {
        return stack;
    }

    public void setStack(ArrayList<T> stack) {
        this.stack = stack;
    }

}
