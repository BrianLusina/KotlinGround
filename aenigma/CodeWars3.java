import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class CodeWars3 {

    public static void main(String[] args){
        System.out.println("Testing for digPow(int n, int p) function");
        System.out.println(digPow(89, 1));// should return 1 since 8¹ + 9² = 89 = 89 * 1
        System.out.println(digPow(92, 1));//should return -1 since there is no k such as 9¹ + 2² equals 92
        System.out.println(digPow(695, 2));//should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
        System.out.println(digPow(46288, 3));//should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51*/

        System.out.println("Testing for breakChocolate(int n, int p) function");
        System.out.println(breakChocolate(5, 5)); // 24);
        System.out.println(breakChocolate(1, 1)); // 0);

        System.out.println("Testing for HighAndLow(String n) function");
        System.out.println(HighAndLow("1 2 3 4 5")); // return "5 1"
        System.out.println(HighAndLow("1 2 -3 4 5")); // return "5 -3"
        System.out.println(HighAndLow("1 9 3 4 -5")); // return "9 -5"
        /*Main method end*/
        System.out.println("Testing for solution() function here");
        System.out.println(solution(10));

        System.out.println("Testing for findIt(int[] n) function here");
        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));//5
        System.out.println(findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));//-1
        System.out.println(findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));//5
        System.out.println(findIt(new int[]{10}));//10
        System.out.println(findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));//10
        System.out.println(findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));//1

        System.out.println("Testing for reverse(String n) function here");
        System.out.println(reverse("hello world"));// "dlrow olleh" (N = 11)
        System.out.println(reverse("abcd"));// "dcba" (N = 4)
        System.out.println(reverse("12345"));// = "54321" (N = 5)*/

        System.out.println("Testing for sumOfN(int n) function here");
        System.out.println(Arrays.toString(sumOfN(3)));
        System.out.println(Arrays.toString(sumOfN(-4)));
        System.out.println(Arrays.toString(sumOfN(1)));
        System.out.println(Arrays.toString(sumOfN(0)));
    }

/**Some numbers have funny properties. For example:

 89 --> 8¹ + 9² = 89 * 1

     695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2

     46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
     Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n. In other words:

     Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
     If it is the case we will return k, if not return -1.

     Note: n, p will always be given as strictly positive integers.

     digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1
     digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k
     digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
     digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51*/
    public static long digPow(int n, int p) {
        int k;
        ArrayList<Integer> resList = new ArrayList<Integer>();
        String str = String.valueOf(n); //convert the integer into a string
        String[] strArr = str.split(""); //split the string into an array
        int sum = 0;
        //perform a for each loop on each element in the array
        for(String x:strArr){
            resList.add((int) Math.pow(Integer.parseInt(x),p));
            p+=1;
        }
        for(Integer d : resList) {
            sum += d;
        }

        k = sum/n; //find k
        if(sum%n==0){ //if k is completely divisible
            return k;
        }else
            return -1; //else return -1
    }

/**
 * Your task is to split the chocolate bar of given dimension n x m into small squares. Each square is of size 1x1 and unbreakable. Implement a function that will return minimum number of breaks needed.

 For example if you are given a chocolate bar of size 2 x 1 you can split it to single squares in just one break, but for size 3 x 1 you must do two breaks.

 If input data is invalid you should return 0 (as in no breaks are needed if we do not have any chocolate to split). Input will always be a non-negative integer.
 * */
    public static int breakChocolate(int n, int m) {
        if(n==0 || m ==0)
            return 0;
        else
            return (n*m)-1;
    }

/**In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

 Example:

 HighAndLow("1 2 3 4 5") // return "5 1"
 HighAndLow("1 2 -3 4 5") // return "5 -3"
 HighAndLow("1 9 3 4 -5") // return "9 -5"
 Notes:

 All numbers are valid Int32, no need to validate them.
 There will always be at least one number in the input string.
 Output string must be two numbers separated by a single space, and highest number is first.*/
    public static String HighAndLow(String numbers) {
        String[] numArr = numbers.split(" ");
        String max,min="";
        ArrayList<Integer> nums = new ArrayList<>();
        for (String n: numArr) {
            nums.add(Integer.parseInt(n));
        }
        max = String.valueOf(Collections.max(nums));
        min = String.valueOf(Collections.min(nums));
        return max +" "+ min;
    }

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.*/
    public static int solution(int number) {
        int[] numArr = IntStream.rangeClosed(1, number).toArray();
        int sum=0;
        for (int i = 0; i <numArr.length ; i++) {
            if(i%3==0 || i%5==0){
                sum +=i;
            }
        }
        return sum;
    }

/**Given an array, find the int that appears an odd number of times.

There will always be only one integer that appears an odd number of times.*/
    public static int findIt(int[] A) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int r =0;
        for (int a : A)
            integerArrayList.add(a);

        for (int x : integerArrayList)
            if (Collections.frequency(integerArrayList, x) % 2 != 0)
                r = x;
        return r;
    }
/**Definition: Recursive function is a function that calls itself during its execution

 Classic factorial counting on Javascript
 function factorial(n) {
 return n <= 1 ? 1 : n * factorial(n-1)
 }
 Your objective is to complete a recursive function reverse() that receives str as String and returns the same string in reverse order

 Rules:

 reverse function should be executed only N times. N = length of the input string
 helper functions are not allowed
 changing the signature of the function is not allowed
 Examples:

 reverse("hello world")// "dlrow olleh" (N = 11)
 reverse("abcd")// "dcba" (N = 4)
 reverse("12345")// = "54321" (N = 5)
 All tests for this Kata are randomly generated, besides checking the reverse logic they will count how many times the reverse() function has been executed.*/

    public static String reverse(String str) {
        if (str == null || str.length() <= 1)
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    /**
     Sum of 'n' Numbers
     sum_of_n (or SequenceSum.sumOfN in Java, SequenceSum.SumOfN in C#) takes an integer n and returns a List (an Array in Java/C#) of length abs(n) + 1. The List/Array contains the numbers in the arithmetic series produced by taking the sum of the consecutive integer numbers from 0 to n inclusive.
     n can also be 0 or a negative value.
     Example:
     5 -> [0, 1, 3, 6, 10, 15]
     -5 -> [0, -1, -3, -6, -10, -15]
     7 -> [0, 1, 3, 6, 10, 15, 21, 28]
     * */

    public static int[] sumOfN(int n) {
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(count<Math.abs(n)+1){
            result.add(IntStream.range(0,count+1).sum());
            count ++;
        }
        if(n<0){
            return result.stream().mapToInt(i ->-i).toArray();
        }else
            return result.stream().mapToInt(i ->i).toArray();
    }

/*Class end*/
}