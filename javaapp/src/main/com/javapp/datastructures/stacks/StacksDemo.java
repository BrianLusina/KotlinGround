package com.javapp.datastructures.stacks;

import java.util.Stack;

/**
 * Created by lusinabrian on 12/07/16.
 * Class showing Stack demonstration, an Abstract Data Type
 */
public class StacksDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Stack is " + stack);
        showPush(stack, 52);
        showPop(stack);
        /*output:
        *Stack is []
        * push 52
        * Stack is now: [52]
        * Popped element is 52
        * Stack is: []
        * */
    }

    /**
     * Method showing how to push elements into a stack
     */
    public static void showPush(Stack stack, int a) {
        stack.push(new Integer(a));
        System.out.println("push " + String.valueOf(a));
        System.out.println("Stack is now: " + stack);
    }

    /**
     * Method demonstrating the use of pop
     */
    public static void showPop(Stack stack) {
        Integer integer = (Integer) stack.pop();
        System.out.println("Popped element is " + String.valueOf(integer));
        System.out.println("Stack is: " + stack);
    }
/*Class end*/
}
