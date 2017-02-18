package java.datastructures.Array;

import java.util.Arrays;

/**
 * Package: java.java.datastructures.Array
 * Created by lusinabrian on 23/07/16 or 23 Jul of 2016,
 * Time: 17:31.
 * Project: JxProjects
 * <p>
 * Description : //Create your own array of integers
 * // Find the maximum and minimum of this array that you just created.
 * // create a variable to hod the maximum
 * // create a variable to hold the minimum
 * // take in the array of numbers
 * // begin to loop through them
 * // put the lowest in its array
 * // put the highest in its array
 * // output the highest then output the lowest
 */
public class Maximum_minimum {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(maximum_min(new int[]{10, 50, 78, 1, 56, 16, 13, 3498, 123, 12})));
        System.out.print(Arrays.toString(maximum_min(new int[]{5, 70, 25, 48, 96, 13, 53, 98, 3, 32})));
        System.out.print(Arrays.toString(maximum_min(new int[]{8, 59, 8, 6, 8, 16, 19, 48, 1, 12})));
        System.out.print(Arrays.toString(maximum_min(new int[]{100, 9, 78, 96, 56, 36, 13, 38, 18, 16})));
    }

    /**
     * @param array, input array with random numbers
     * @implNote gets the maximum and minimum of an array,
     * outputs each individually.
     * creates 2 variables that hold max and min and 1 temporary variable to store 'passing elements'
     * Loop through array checking if the first element is greater than the second element,
     * if so, assign the bigger element to a temporary variable swap, assign the smaller element to the bigger elements' position, assign the bigger element to the smaller element's position.
     */
    public static int[] maximum_min(int[] array) {
        int swap;
        int max, min;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }

        /*assign the smallest and largest values to variables*/
        min = array[0];
        max = array[array.length - 1];

        /*out put result*/
        return new int[]{max, min};
    }/*method end*/
/*CLASS END*/
}
