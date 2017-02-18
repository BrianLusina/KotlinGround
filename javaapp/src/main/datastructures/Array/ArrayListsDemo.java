package main.datastructures.Array;

import java.util.ArrayList;

/**
 * Package: datastructures.Array
 * Created by lusinabrian on 11/07/16.
 * Time: 09:15.
 * Project: JxProjects
 */
public class ArrayListsDemo {
    public static void main(String[] args) {
        // create an empty array list
        ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

        // use add() method to add elements
        arrlist.add(20);
        arrlist.add(15);
        arrlist.add(30);
        arrlist.add(45);

        System.out.println("Size of list: " + arrlist.size());

        // Print all the elements  in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }

        // Remove element at 3rd position
        arrlist.remove(2);

        System.out.println("Size of list: " + arrlist.size());

        //Print all the elements available in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }
        double[] myList = {1.9, 2.9, 3.4, 3.5};

        // Printing  array elements
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
        // Summing all elements
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);

        // Finding the largest element
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);

        System.out.println(myList.toString());
    }/*MAIN END*/
/*CLASS END*/
}
