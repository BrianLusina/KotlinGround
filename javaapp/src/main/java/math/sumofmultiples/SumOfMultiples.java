package java.math.sumofmultiples;

import java.util.stream.IntStream;

public class SumOfMultiples {

    public int Sum(int number, int[] multiples) {
        //create range for the numbers
        if (multiples.length == 0) {
            return 0;
        }
        IntStream numbers = IntStream.rangeClosed(0, number - 1);
        if (multiples.length == 3) {
            return numbers
                    .filter(n -> n % multiples[0] == 0 || n % multiples[1] == 0 || n % multiples[2] == 0)
                    .sum();
        }

        return numbers.filter(n -> n % multiples[0] == 0 || n % multiples[1] == 0).sum();
    }
}
