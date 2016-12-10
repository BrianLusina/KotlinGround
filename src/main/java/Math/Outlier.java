package main.java.Math;

import java.util.ArrayList;

/**
 * Package: Math
 * Created by lusinabrian on 23/07/16 or 23 Jul of 2016,
 * Time: 23:16.
 * Project: JxProjects
 * Description:
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers. The integers in the array are either entirely odd or entirely even except for a single integer N. Write a method that takes the array as an argument and returns N.
 * For example:
 * [2, 4, 0, 100, 4, 11, 2602, 36]
 * Should return: 11
 * [160, 3, 1719, 19, 11, 13, -21]
 * Should return: 160
 */
public class Outlier {
    public static void main(String[] args) {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};

        System.out.printf("Expected:%d Actual: %d\n", 3, find(exampleTest1));
        System.out.printf("Expected:%d Actual: %d\n", 206847684, find(exampleTest2));
        System.out.printf("Expected:%d Actual: %d\n", 0, find(exampleTest3));
    }

    static int find(int[] integers) {
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        for (int n : integers) {
            if (n % 2 == 0)
                evens.add(n);
            else
                odds.add(n);
        }

        if (evens.size() > odds.size())
            return odds.get(0);
        else
            return evens.get(0);
    }

/*CLASS END*/
}