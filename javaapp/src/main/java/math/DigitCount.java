package main.math;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Package: java.java.math
 * Created by lusinabrian on 23/07/16 or 23 Jul of 2016,
 * Time: 22:07.
 * Project: JxProjects
 * Description:
 * Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer. Square all numbers k (0 <= k <= n) between 0 and n. Count the numbers of digits d used in the writing of all the k**2. Call nb_dig (or nbDig or ...) the function taking n and d as parameters and returning this count.
 * <p>
 * Examples:
 * <p>
 * n = 10, d = 1, the k*k are 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
 * We are using the digit 1 in 1, 16, 81, 100. The total count is then 4.
 * <p>
 * nb_dig(25, 1):
 * the numbers of interest are
 * 1, 4, 9, 10, 11, 12, 13, 14, 19, 21 which squared are 1, 16, 81, 100, 121, 144, 169, 196, 361, 441
 * so there are 11 digits `1` for the squares of
 */
public class DigitCount {
    public static void main(String[] args) {
        System.out.printf("Actual: %d, Expected:%d\n", nbDig(5750, 0), 4700);
        System.out.printf("Actual: %d, Expected:%d\n", nbDig(11011, 2), 9481);
        System.out.printf("Actual: %d, Expected:%d\n", nbDig(12224, 8), 7733);
        System.out.printf("Actual: %d, Expected:%d\n", nbDig(11549, 1), 11905);
    }

    public static int nbDig(int n, int d) {
        String dStr = String.valueOf(d);
        int counter = 0;
        double[] squares = IntStream.rangeClosed(0, n).mapToDouble(i -> Math.pow(i, 2)).toArray();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (double y : squares) {
            arrayList.add((int) y);
        }

        for (int x : arrayList) {
            String xStr = String.valueOf(x);
            if (xStr.contains(dStr))
                for (String s : xStr.split("")) {
                    if (s.equals(dStr)) {
                        counter++;
                    }
                }
        }
        return counter;
    }

/*CLASS EMD*/
}
