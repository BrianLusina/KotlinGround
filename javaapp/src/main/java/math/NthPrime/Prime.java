package java.math.NthPrime;

import java.util.stream.IntStream;

public class Prime {

    public static int nth(int nthNum){
        if(nthNum < 1){
            throw new IllegalArgumentException("No prime number less than 1");
        }

        int primesFound = 0;
        int possiblePrime = 1;

        while(primesFound < nthNum){
            possiblePrime++;

            if(isPrime(possiblePrime)){
                primesFound++;
            }
        }

        return possiblePrime;
    }

    /**Determines if a number is prime
     * @param n The number to determine for primality*/
    private static boolean isPrime(int n){
        switch (n){
            case 1:
                return false;
            case 2:
                return true;
        }

        boolean divisible = IntStream
                .rangeClosed(2, (int) Math.ceil(Math.sqrt(n)))
                .anyMatch((int i) -> n % i == 0);

        return !divisible;
    }

}
