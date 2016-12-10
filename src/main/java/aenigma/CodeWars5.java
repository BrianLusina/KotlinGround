import java.util.ArrayList;

/*CodeWars Day 5*/
public class CodeWars5 {
    public static void main(String[] args) {
        System.out.println("TESTING FOR countPassengers(ArrayList<int[]> function)");
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{10, 0});
        list.add(new int[]{3, 5});
        list.add(new int[]{2, 5});
        System.out.println(countPassengers(list));

        System.out.println("TESTING FOR digitalRoot(int n) function)");
        System.out.println(digitalRoot(493193));
        System.out.println(digitalRoot(132189));
        System.out.println(digitalRoot(16));
        System.out.println(digitalRoot(942));
        System.out.println(digitalRoot(132189));
        System.out.println(digitalRoot(10));
        //MAIN END
    }

    /**
     * There is a bus moving in the city, and it takes and drop some people in each bus stop.
     * You are provided a list (or array in JS) of integer array. Each integer array has two items which represent number of people get into bus (The first item) and number of people get off the bus (The second item).
     * The first integer array has 0 number in the second item, since the bus is empty in the first bus stop.
     * Your task is to return number of people in the bus after the last bus station. Take a look on the test cases :)
     * Please keep in mind that the test cases ensure that the number of people in the bus is always >= 0. So the return integer can't be negative.
     */
    public static int countPassengers(ArrayList<int[]> stops) {
        int res = 0;
        for (int[] n : stops) {
            res += n[0] - n[1];
        }
        return res;
    }


    /**
     * """
     * In this kata, you must create a digital root function.
     * <p>
     * A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only applicable to the natural numbers.
     * <p>
     * Here's how it works (Ruby example given):
     * <p>
     * digital_root(16)
     * => 1 + 6
     * => 7
     * <p>
     * digital_root(942)
     * => 9 + 4 + 2
     * => 15 ...
     * => 1 + 5
     * => 6
     * <p>
     * digital_root(132189)
     * => 1 + 3 + 2 + 1 + 8 + 9
     * => 24 ...
     * => 2 + 4
     * => 6
     * <p>
     * digital_root(493193)
     * => 4 + 9 + 3 + 1 + 9 + 3
     * => 29 ...
     * => 2 + 9
     * => 11 ...
     * => 1 + 1
     * => 2
     * """
     */
    public static int digitalRoot(int n) {
        int res = 0;
        String[] nStrArr = String.valueOf(n).split("");
        if (n < 10) {
            return n;
        } else {
            for (String s : nStrArr) {
                res += Integer.parseInt(s);
            }
        }
        return digitalRoot(res);
    }


//CLASS END
}
