package com.javapp.math.raindrops;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;

public class RaindropsTest{

    public RaindropsTest(){}

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Non-primes
                {1, "1"},
                {52, "52"},
                {12121, "12121"},

                // Numbers with 3 as a prime factor
                {3, "Pling"},
                {6, "Pling"},
                {9, "Pling"},

                // Numbers with 5 as a prime factor
                {5, "Plang"},
                {10, "Plang"},
                {25, "Plang"},

                // Numbers with 7 as a prime factor
                {7, "Plong"},
                {14, "Plong"},
                {49, "Plong"},

                // Numbers with multiple activating prime factors
                {15, "PlingPlang"},
                {21, "PlingPlong"},
                {35, "PlangPlong"},
                {105, "PlingPlangPlong"},
        });
    }

    //todo: look into this test
    @Ignore
    @Test
    public void test() {
        //assertEquals(expectedOutput, Raindrops.convert(input));
    }
}
