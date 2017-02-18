package main.java.Hannah;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by lusinabrian on 21/01/16.
 * LinkedLists, a data structure consisting of a group of nodes which together represent a sequence,each node
 * is composed of data and a link to the next node in the sequence.
 * The LinkedLists is very similar in syntax to the ArrayList.
 * You can easily change an ArrayList to a LinkedLists by changing the object type.
 * You cannot specify an initial capacity for the LinkedLists.
 * The most notable difference between the LinkedLists and the ArrayList is in the way they store objects.
 * The ArrayList is better for storing and accessing data, as it is very similar to a normal array.
 * The LinkedLists is better for manipulating data, such as making numerous inserts and deletes.
 * <p>
 * In addition to storing the object, the LinkedLists stores the memory address (or link) of the element that follows it.
 * It's called a LinkedLists because each element contains a link to the neighboring element.
 * <p>
 * Since the LinkedLists is an array, you can use the enhanced for loop to iterate over its elements.
 * <p>
 * Summary:
 * - Use an ArrayList when you need rapid access to your data.
 * - Use a LinkedLists when you need to make a large number of inserts and/or deletes.
 */
public class LinkedLists {

    public static void main(String[] args) {
    /*Resizable array colors with an initial capacity of 10*/
        LinkedList<String> colors = new LinkedList();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Purple");
        colors.add("Yellow");

        //does the ArrayList contain Orange?
        if (colors.contains("Orange")) {
            System.out.println("LinkedList colors contains Orange \n");
        } else {
            System.out.println("LinkedList colors does not contains Orange \n");
        }

        //return a specified color
        System.out.println("Color at index 2 " + colors.get(2) + "\n");

        //how many colors are here and what are they?
        System.out.println("There are " + colors.size() + " colors in the ArrayList colors and they are " + colors);
/**
 * An Iterator is an object that enables to cycle through a collection, obtain or remove elements.
 Before you can access a collection through an iterator, you must obtain one.
 Each of the collection classes provides an iterator() method that returns an iterator to the start of the collection.
 By using this iterator object, you can access each element in the collection, one element at a time.

 The Iterator class provides the following methods:
 hasNext(): Returns true if there is at least one more element; otherwise, it returns false.
 next(): Returns the next object and advances the iterator.
 remove(): Removes the last object that was returned by next from the collection.

 it.next() returns the first element in the list and then moves the iterator on to the next element.
 Each time you call it.next(), the iterator moves to the next element of the list.
 */
        LinkedList<String> animals = new LinkedList<String>();
        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        Iterator<String> it = animals.iterator();
        String value = it.next();
        System.out.println(value);
/**
 Typically, iterators are used in loops. At each iteration of the loop, you can access the corresponding list element.
 While loop determines whether the iterator has additional elements, prints the value of the element, and advances the iterator to the next.
 */
        while (it.hasNext()) {
            value = it.next();
            System.out.println(value);
        }
        //Main end
    }
//End
}
