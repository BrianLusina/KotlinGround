package aenigma;

import java.util.stream.IntStream;

/**
 * Created by lusinabrian on 28/05/16.
 */
public class CodeWars2 {

    public static void main(String[] args) {
        System.out.println("Testing for calculateTip() function");
        System.out.println(calculateTip(30d, "poor"));
        System.out.println(calculateTip(107.65, "GReat"));
        System.out.println(calculateTip(20d, "Excellent"));
        System.out.println(calculateTip(20d, "hi"));
        System.out.println("Testing for GetSum(int a, int b) function");
        System.out.println(GetSum(1, 0));// == 1   // 1 + 0 = 1
        System.out.println(GetSum(1, 2));// == 3   // 1 + 2 = 3
        System.out.println(GetSum(0, 1));// == 1   // 0 + 1 = 1
        System.out.println(GetSum(1, 1));// == 1   // 1 Since both are same
        System.out.println(GetSum(-1, 0));// == -1 // -1 + 0 = -1
        System.out.println(GetSum(-1, 2));// == 2  // -1 + 0 + 1 + 2 = 2

        System.out.println("Testing for monkeyCount(n) function");
        System.out.println(monkeyCount(10));

        System.out.println("Testing for squareDigit(n) function");
        System.out.println(squareDigits(155));

        System.out.println("Testing for findNextSquare");
        System.out.println(findNextSquare(144));
        System.out.println(findNextSquare(625));// --> returns 676
        System.out.println(findNextSquare(114));// --> returns -1

        System.out.println("Testing for bonusTime() function");
        System.out.println(bonusTime(10000, true));
        System.out.println(bonusTime(62005, false));
        System.out.println(bonusTime(5500, true));

        System.out.println("Testing for narcissistic(int n) function");
        System.out.println(narcissistic(153));
        System.out.println(narcissistic(7)); //# '7 is narcissistic');
        System.out.println(narcissistic(371));// #'371 is narcissistic');
        System.out.println(narcissistic(122));// #'122 is not narcissistic')
        System.out.println(narcissistic(4887));

        System.out.println(notVisibleCubes(3l));

    /*Main Method end*/
    }


    /**
     * Write a function, calculateTip(amount, rating) which calculates how much you need to tip based on the total amount of the bill and the service.
     * <p>
     * You need to consider the following ratings:
     * <p>
     * Terrible: tip 0%
     * Poor: tip 5%
     * Good: tip 10%
     * Great: tip 15%
     * Excellent: tip 20%
     * The rating is case insensitive. If an unrecognised rating is input, then you need to return:
     * <p>
     * "Rating not recognised" in Javascript, Python and Ruby...
     * ...or null in Java
     * Because you're a nice person, you always round up the tip, regardless of the service.
     */
    public static Integer calculateTip(double amount, String rating) {
        switch (rating.toLowerCase()) {
            case "terrible":
                return (int) Math.ceil(amount * 0);
            case "poor":
                return (int) Math.ceil(amount * 0.05);
            case "good":
                return (int) Math.ceil(amount * 0.1);
            case "great":
                return (int) Math.ceil(amount * 0.15);
            case "excellent":
                return (int) Math.ceil(amount * 0.2);
            default:
                return null;
        }
    }

    /**
     * Given two integers, which can be positive and negative, find the sum of all the numbers between including them too and return it. If both numbers are equal return a or b.
     * <p>
     * Note! a and b are not ordered!
     * <p>
     * Example:
     * GetSum(1, 0) == 1   // 1 + 0 = 1
     * GetSum(1, 2) == 3   // 1 + 2 = 3
     * GetSum(0, 1) == 1   // 0 + 1 = 1
     * GetSum(1, 1) == 1   // 1 Since both are same
     * GetSum(-1, 0) == -1 // -1 + 0 = -1
     * GetSum(-1, 2) == 2  // -1 + 0 + 1 + 2 = 2
     */

    public static int GetSum(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    /**
     * You take your son to the forest to see the monkeys. You know that there are a certain number there (n), but your son is too young to just appreciate the full number, he has to start counting them from 1.
     * <p>
     * As a good parent, you will sit and count with him. Given the number (n), populate an array with all numbers up to and including that number, but excluding zero.
     * <p>
     * For example, if n = 10:
     * <p>
     * return [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     */
    public static int[] monkeyCount(final int n) {
        return IntStream.rangeClosed(1, n).toArray();
    }

    /**
     * Welcome. In this kata, you are asked to square every digit of a number.
     * <p>
     * For example, if we run 9119 through the function, 811181 will come out.
     * <p>
     * Note: The function accepts an integer and returns an integer
     */
    public static int squareDigits(int n) {
        String str = String.valueOf(n); //convert to a string
        String[] strArray = str.split(""); //split into an array
        String res = ""; //create an empty string
        //perform a foreach loop on the array, converting each into an integer, squaring it, converting
        //result into an integer, then into a string and appending the result to the empy string
        for (String x : strArray) {
            res += String.valueOf((int) Math.pow((Integer.parseInt(x)), 2));
        }
        //convert the string into an integer
        return Integer.parseInt(res);
    }


    /**
     * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
     * <p>
     * If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
     * <p>
     * Examples:
     * <p>
     * findNextSquare(121) --> returns 144
     * findNextSquare(625) --> returns 676
     * findNextSquare(114) --> returns -1 since 114 is not a perfect
     */

    public static long findNextSquare(long sq) {
        //check if ir is a perfect square
        if (Math.round(Math.sqrt(sq)) == Math.sqrt(sq)) {
            return (long) Math.pow(Math.sqrt(sq) + 1, 2);
        }//else return -1
        return -1;
    }

    /**
     * It's bonus time in the big city! The fatcats are rubbing their paws in anticipation... but who is going to make the most money?
     * <p>
     * Build a function that takes in two arguments (salary, bonus). Salary will be an integer, and bonus a boolean.
     * <p>
     * If bonus is true, the salary should be multiplied by 10. If bonus is false, the fatcat did not make enough money and must receive only his stated salary.
     * <p>
     * Return the total figure the individual will receive as a string prefixed with '£' (JS and Java) or '$' (Ruby and Python).
     */
    public static String bonusTime(final int salary, final boolean bonus) {
        if (bonus) {
            return "\u00A3" + String.valueOf(salary * 10);
        }
        return "\u00A3" + String.valueOf(salary);
    }

    /**
     * A Narcissistic Number is a number which is the sum of its own digits, each raised to the power of the number of digits.
     * For example, take 153 (3 digits):
     * 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 and 1634 (4 digits):
     * 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634
     * The Challenge:
     * Your code must return true or false depending upon whether the given number is a Narcissistic number.
     * Error checking for text strings or other invalid inputs is not required, only valid integers will be passed into the function.
     */
    public static boolean narcissistic(int n) {
        String nStr = String.valueOf(n);
        int total = 0;
        for (String m : nStr.split("")) {
            total += Math.pow((double) Integer.parseInt(m), nStr.length());
        }
        return total == n;
    }

    /**
     * Ask a small girl - "How old are you?". She always says strange things... Lets help her!
     * For correct answer program should return int from 0 to 9 ;)
     * Assume test input string always valid and may look like "1 year old" or "5 years old", etc.. The first char is number only =)
     **/
    public static int howOld(final String herOld) {
        return Integer.parseInt(herOld.split("")[0]);
    }

    /**
     * Imagine there's a big cube consisting of n^3 small cubes. Calculate, how many small cubes are not visible from outside.
     * <p>
     * For example, if we have a cube which has 4 cubes in a row, then the function should return 8, because there are 8 cubes inside our cube (2 cubes in each dimension)
     */
    public static Long notVisibleCubes(Long n) {
        if (n <= 2)
            return (long) 0;
        return (long) Math.pow(n - 2, 3);
    }


    /**
     * altERnaTIng cAsE <=> ALTerNAtiNG CaSe
     * Define String.prototype.toAlternatingCase ( toAlternatingCase(String) in Java) such that each lowercase letter becomes uppercase and each uppercase letter becomes lowercase. For example:
     * Note to no Java langs
     * You must NOT alter the original string.
     */
    public static String toAlternativeString(String string) {
        String[] strArr = string.split("");
        String res = "";
        for (String x : strArr) {
            if (x.equals(x.toLowerCase()))
                res += x.toUpperCase();
            else
                res += x.toLowerCase();
        }
        return res;
    }
/*CLASS END*/
}