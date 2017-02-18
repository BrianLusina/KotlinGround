package main.datastructures.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Package: ${PACKAGE_NAME}
 * Created by lusinabrian on 11/07/16 or 23 Jul of 2016,
 * Time: 17:32.
 * Project: JxProjects
 * Description:
 */
public class ArraysDemo {

    public static void main(String[] args) {
        int[] x = new int[]{43, 12, 9, 89, 100};
        String[] y = new String[]{"a", "c", "z", "e", "f", "h", "b"};
        /*sort the arrays in ascending orders*/
        Arrays.sort(x);
        Arrays.sort(y);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        System.out.println(Arrays.toString(threeSort(5, 10, 9)));
        System.out.println(Arrays.toString(threeSort(20, 50, 9)));
        System.out.println(Arrays.toString(threeSort(5, 15, 9)));

    }

    /**
     * Given three numbers as input, find the min, middle and max of the three.
     * Return an array of the numbers in ascending order.
     *
     * @param x the first integer input
     * @param y the second integer input
     * @param z the 3rd integer input
     * @return result, returns the result of the sorted array
     * @implNote Instantiate and array with the 3 inputs as elements of the array,
     * sort the array using java.java.datastructures.Array.sort(array) and return the result
     */
    public static int[] threeSort(int x, int y, int z) {
        int[] result = new int[]{x, y, z};

        Arrays.sort(result);
        return result;
    }

    public static int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : numbers) {
            if (x % divider == 0)
                result.add(x);
        }
        return result.stream().mapToInt(x -> x).toArray();
    }


}/*CLASS END*/

