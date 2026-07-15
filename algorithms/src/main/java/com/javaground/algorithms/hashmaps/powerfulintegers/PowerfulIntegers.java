package com.javaground.algorithms.hashmaps.powerfulintegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    // Function to find all powerful integers <= bound
    public static List<Integer> of(int x, int y, int bound) {
        // Use a set to store unique powerful integers
        Set<Integer> resultSet = new HashSet<>();

        // Compute powers of x up to bound
        // If x == 1, x^i is always 1, so only need i=0
        long powX = 1; // x^0 = 1
        while (powX <= bound) {
            // For each power of x, iterate over powers of y
            long powY = 1; // y^0 = 1
            while (powX + powY <= bound) {
                // Add the powerful integer to the set
                resultSet.add((int)(powX + powY));
                // If y is 1, y^j is always 1, so break after first iteration
                if (y == 1) break;
                // Move to next power of y
                powY *= y;
            }
            // If x is 1, x^i is always 1, so break after first iteration
            if (x == 1) break;
            // Move to next power of x
            powX *= x;
        }

        // Convert set to list and return
        return new ArrayList<>(resultSet);
    }

    public static List<Integer> logarithmicBounds(int x, int y, int bound) {
        int a = x == 1 ? bound : (int) (Math.log(bound) / Math.log(x));
        int b = y == 1 ? bound : (int) (Math.log(bound) / Math.log(y));

        HashSet<Integer> powerfulIntegers = new HashSet<>();

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {

                int value = (int) Math.pow(x, i) + (int) Math.pow(y, j);

                if (value <= bound) {
                    powerfulIntegers.add(value);
                }

                // No point in considering other powers of "1".
                if (y == 1) {
                    break;
                }
            }

            if (x == 1) {
                break;
            }
        }

        return new ArrayList<>(powerfulIntegers);
    }
}
