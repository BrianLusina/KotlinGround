package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Package: Math
 * Created by lusinabrian on 25/07/16 or 25 Jul of 2016,
 * Time: 09:15.
 * Project: JxProjects
 * Description: Given a number, find the next higher number using only the digits in the given number.
 * For example if the given number is 1508, the next higher number with same digits is 8510.
 */
public class NextHighest {
    public static void main(String[] args){
        System.out.printf("Actual: %d, Expected: %d\n",nxtHigh(1508),8510);
        System.out.printf("Actual: %d, Expected: %d\n",nxtHigh(1324),4321);
        System.out.printf("Actual: %d, Expected: %d\n",nxtHigh(1005),5001);
    }
    /**
     * Converts the number to individual digits by converting to a string, splitting it
     * then iterates through the string, converting each string to a number adding them to a list,
     * Use a Comparator to compare each integer and sort the list
     * add each integer to a string builder and convert to a string
     * Convert to an integer
     * @param n, integer input*/
    public static int nxtHigh(int n){
        String[] nStrArr = String.valueOf(n).split("");
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String s : nStrArr){
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list, (int1, int2) -> (int1 > int2 ? -1 : (Objects.equals(int1, int2) ? 0 : 1)));

        list.forEach(sb::append);

        return Integer.parseInt(sb.toString());
    }/*METHOD END*/

/*CLASS END*/
}