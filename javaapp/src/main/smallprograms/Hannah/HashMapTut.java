package main.java.Hannah;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lusinabrian on 21/01/16.
 * HashMap is used for storing data collections as key and value pairs.
 * One object is used as a key (index) to another object (the value).
 * The put, remove, and get methods are used to add, delete, and access values in the HashMap.
 * Use the get method and the corresponding key to access the HashMap elements.
 * <p>
 * A HashMap cannot contain duplicate keys. Adding a new item with a key that already exists overwrites the old element.
 * The HashMap class provides containsKey and containsValue methods that determine the presence of a specified key or value.
 * If you try to get a value that is not present your map, it returns the value of null.
 */
public class HashMapTut {

    public static void main(String[] args) {
        HashMap<String, Integer> points = new HashMap<String, Integer>();
        points.put("Amy", 154);
        points.put("Dave", 42);
        points.put("Rob", 733);
        System.out.println(points.get("Dave"));

        /**A Set is a collection that cannot contain duplicate elements.
         It models the mathematical set abstraction.
         One of the implementations of the Set is the HashSet class.*/
        HashSet<String> set = new HashSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);

/**
 *The HashSet class does not automatically retain the order of the elements as they're added.
 * To order the elements, use a LinkedHashSet, which maintains a linked list of the set's elements in the order in which they were inserted.

 What is hashing?
 A hash table stores information through a mechanism called hashing, in which a key's informational content is used to determine a unique value called a hash code.
 So, basically, each element in the HashSet is associated with its unique hash code.
 **/
    }
//end
}
