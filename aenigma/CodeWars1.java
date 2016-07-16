import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CodeWars1 {

    public static void main(String[] args){
        String[] strArr = {"h","o","l","a"};
        int[] numArr = {1,3,5,7,9};
        System.out.println(fact(2));

        System.out.println(resistance(20,20,20));

        System.out.println(printArray(strArr));

        System.out.println("Test for pipFix");
        pipeFix(numArr);

        System.out.println("Test for area");
        System.out.println(area(3D));

        System.out.println("Test for isDigit()");
        System.out.println( isDigit("")); //false
        System.out.println( isDigit("7")); //true
        System.out.println( isDigit(" ")); //false
        System.out.println( isDigit("a")); //false
        System.out.println( isDigit("a5")); //false
        System.out.println( isDigit("14")); //false

    //MAIN METHOD END
    }

    /**
     * Created by lusinabrian on 17/05/16.
     * Class to calculate the factorial
     * In mathematics, the factorial of a non-negative integer n, denoted by n!,
     * is the product of all positive integers less than or equal to n.
     * For example: 5! = 5 * 4 * 3 * 2 * 1 = 120. By convention the value of 0! is 1.
     Write a function to calculate factorial for a given input. If input is
     below 0 or above 12 throw an exception of type ArgumentOutOfRangeException (C#) or
     IllegalArgumentException (Java).
     */
    public static int fact(int n){
        if (n < 0 || n >= 12) {
            throw new IllegalArgumentException(Integer.toString(n) + " out of range");
        } else if(n == 0){
            return 1;
        }else
            return n * fact(n - 1);
    }
/**Write the function resistor_parallel that recieve an undefined number of resistances parallel resistors and return the total resistance.
 You can assume that there will be no 0 as parameter. Also there will be at least 2 arguments.
 Formula: 1/total = 1/r1 + 1/r2 + .. + 1/rn total = 1 / (1/r1 + 1/r2 + .. + 1/rn)
Examples: resistor_parallel(20, 20) will return 10.0 resistor_parallel(20,20, 40): will return 8.0**/
    public static double resistance(int...args){
        double total=0;
        for (int a: args){
            double r = (1/((double)a));
            total+=r;
        }
        return 1/total;
    }

/**
 Input: Array of elements
 ["h","o","l","a"]
 Output: String with comma delimited elements of the array in th same order.
"h,o,l,a"
 *
 * **/
    public static String printArray(Object array[]) {
        String str = "";
        StringBuilder res = new StringBuilder();
        for(Object i: array){
            //convert each item to a string
            str = String.valueOf(i);
            res.append(str);
            res.append(",");
        }
        return res.length()>0 ? res.substring(0,res.length() -1): "";
    }

/**
 * Looks like some hoodlum plumber and his brother has been running around and damaging your stages again.

 The pipes connecting your level's stages together need to be fixed before you recieve any more complaints. Each pipe should be connecting, since the levels ascend, you can assume every number in the sequence after the first index will be greater than the previous and that there will be no duplicates.

 Task

 Given the a list of numbers, return the list so that the values increment by 1 for each index up to the maximum value.

 Example:

 Input: 1,3,5,6,7,8

 Output: 1,2,3,4,5,6,7,8
 * */

    public static int[] pipeFix(int[] numbers) {
        return IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).toArray();
    }

/**
 * Complete the function circleArea so that it will return the area of a circle with the given radius. Round the returned number to two decimal places (except for Haskell). If the radius is not positive or not a number, return false.

 Example:

 Circle.area(-1485.86);    //returns false
 Circle.area(0);           //returns false
 Circle.area(43.2673);     //returns 5881.25
 Circle.area(68);          //returns 14526.72
 * */

    public static double area(double radius) {
        if(radius<=0){
            throw new IllegalArgumentException("false");
        }else{
            return (Math.round(Math.PI*Math.pow(radius,2)*100))/100D;
        }
    }

/**
 * Implement String#digit? (in Java  isDigit(String)), which should return true if given object is a digit (0-9), false otherwise.
 * */
    public static boolean isDigit(String s) {
        String digit = "(\\d)";
        Pattern digitPattern = Pattern.compile(digit);
        Matcher matcherDig = digitPattern.matcher(s);
        if(s.length() >1){
            return false;
        }else{
            return matcherDig.find();
        }
    }

//CLASS END
}