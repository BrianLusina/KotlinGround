package main.java.DataStructures.LinkedList;

public class Deque<T> {


    public final void push(T elem) {

    }

    public final T pop() {

    }

    public final T shift() {

    }

    public final void unshift(T value) {

    }

    private static class Element<T> {
        final T value;
        Element next;
        Element prev;

        Element(T value) {
            this.value = value;
        }
    }


}
