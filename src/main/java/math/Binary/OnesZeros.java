package Math.Binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lusinabrian on 16/07/16.
 * Given an array of one's and zero's convert the equivalent Math.Binary.binary value to an integer.
 * <p>
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the Math.Binary.binary representation of 1
 * <p>
 * Examples:
 * <p>
 * Testing: [0, 0, 0, 1] ==> 1
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 0, 1] ==> 5
 * Testing: [1, 0, 0, 1] ==> 9
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 1, 0] ==> 6
 * Testing: [1, 1, 1, 1] ==> 15
 * Testing: [1, 0, 1, 1] ==> 11
 */

public class OnesZeros {
    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 0, 0, 1))));
        System.out.println(ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 1, 1, 1))));//15
        System.out.println(ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 1, 1, 0))));//6
        System.out.println(ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 0, 0, 1))));//9
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String s = "";
        for (int n : binary) {
            s += String.valueOf(n);
        }
        return Integer.parseInt(s, 2);
    }
}
