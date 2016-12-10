package main.java.Algorithms;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{18, 29, 1, 100, 17};
        int[] arrTwo = new int[]{100, 16, 33, 48, 60, 21, 80};
        /*Bubble sort Ascending*/
        System.out.println(Arrays.toString(bubbly(arr)));
        System.out.println(Arrays.toString(bubbly(arrTwo)));
    }

    /**
     * @param toSort array to perform the bubble sort
     * @return toSort the sorted array
     * @implNote set flag to true to begin first pass, initialize the step variable, create the temp variable
     * within while loop, set the flag to false awaiting first pass
     * record the steps taken in a variable called steps
     * holds the temp value for the current element in array
     * assign the current position of the array to the next element
     * assign the next position of the array to the temp value
     * set the flag to true to allow continuing of loop, record the steps taken
     */
    public static int[] bubbly(int[] toSort) {
        boolean flag = true;
        int steps = 0;
        int temp;
        while (flag) {
            flag = false;
            for (int x = 0; x < toSort.length - 1; x++) {
                if (toSort[x] > toSort[x + 1]) {
                    temp = toSort[x];
                    toSort[x] = toSort[x + 1];
                    toSort[x + 1] = temp;
                    flag = true;
                }
                steps++;
            }
        }
        System.out.println(String.valueOf(steps / 2) + " steps taken");
        return toSort;
    }
/*CLASS END*/
}
