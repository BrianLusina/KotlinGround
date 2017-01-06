package math.Primefactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 26/07/16 or 26 Jul of 2016,
 * Time: 22:32.
 * Project: math.Primefactors
 */
public class PrimeFactors {
    /**
     * 1. Takes care of composite numbers, such as 2, such that if number is divisible by 2, add it to list, then divide by 2
     * <p>
     * 2. Also, takes care of composite numbers, 3, taking care of odd numbers, for loop starts at 3 and increments by 3 upto square root of input, all remaining prime factors must be odd (difference of two prime factors must be at least 2), this explains why i is incremented by 2.
     * we run a loop and do following in loop
     * a) Find the least prime factor x (must be less than √input,)
     * b) Remove all occurrences x from input by repeatedly dividing n by x.
     * c) Repeat steps a and b for divided input and x+=2. The steps a and b are repeated till input becomes either 1 or a prime number.
     * <p>
     * 3. checks to see if input is a prime number greater than two, if so, add to the list
     *
     * @param input, number to evaluate to obtain prime factors
     */
    public static List<Long> getForNumber(long input) {
        ArrayList<Long> primes = new ArrayList<Long>();
        while (input % 2L == 0) {
            primes.add(2L);
            input /= 2L;
        }

        for (long x = 3; x <= Math.sqrt(input); x += 2) {
            while (input % x == 0) {
                primes.add(x);
                input /= x;
            }
        }
        if (input > 2) {
            primes.add(input);
        }

        return primes;
    }/*METHOD END*/
/*CLASS END*/
}