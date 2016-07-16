package ControlFlow;

import java.util.ArrayList;

/**
 * Created by lusinabrian on 08/07/16.
 */
public class forloops {
    public static void main(String[] args){
        System.out.println(leaps(2016,2036)); //output [2016, 2020, 2024, 2028, 2032, 2036]
        System.out.println(leaps(2016,2012));
    }

    public static ArrayList<Integer> leaps(int begin, int end){
        if(end< begin){
            throw new NumberFormatException(String.valueOf(end) + " cannot be less than " + String.valueOf(begin));
        }
        ArrayList<Integer> leapYears = new ArrayList<>();
        for(int n = begin ; n <= end; n++) {
            //check if year is leap
            if ((!(n % 100 == 0) && n % 400 == 0) || n % 4 == 0) {
                leapYears.add(n);
            }
        }
        return leapYears;
    }
}
