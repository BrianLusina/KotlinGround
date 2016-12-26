package datastructures.stacks;

import java.util.ArrayList;

/**
 * datastructures.stacks
 * Created by lusinabrian on 26/12/16.
 * Description:
 */
public class Stacks<T> implements StackInterface<T>{
    private int maxSize;
    private ArrayList<T> stack;

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
        if(this.isEmpty()){
            stack.add(t);
        }else if(!this.isEmpty() && !this.isFull()){
            stack.add(t);
        }
        if(this.isFull()){
            throw new StackOverflowError("Stack size exceeded");
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
        return stack.size();
    }

    @Override
    public boolean isFull() {
        return stack.size() == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
