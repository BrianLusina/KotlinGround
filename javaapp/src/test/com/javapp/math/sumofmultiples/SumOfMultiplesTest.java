package com.javapp.math.sumofmultiples;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Ignore;


public class SumOfMultiplesTest extends TestCase {
    public SumOfMultiplesTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void testSumOfMultiplesOf3and4UpToOne() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                3,
                5
        };
        int output = mySum.Sum(1, set);
        assertEquals(0, output);

    }


    @org.junit.Test

    public void testSumOfMultiplesOf3and5UpToFour() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                3,
                5
        };
        int output = mySum.Sum(4, set);
        assertEquals(3, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf3and5UpToTen() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                3,
                5
        };
        int output = mySum.Sum(10, set);
        assertEquals(23, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf3and5UpToOneHundred() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                3,
                5
        };
        int output = mySum.Sum(100, set);
        assertEquals(2318, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf3and5UpToOneThousand() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                3,
                5
        };
        int output = mySum.Sum(1000, set);
        assertEquals(233168, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf7and13and17UpToTwenty() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                7,
                13,
                17
        };
        int output = mySum.Sum(20, set);
        assertEquals(51, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf4and6UpToFifteen() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                4,
                6
        };
        int output = mySum.Sum(15, set);
        assertEquals(30, output);

    }


    @org.junit.Test
    @Ignore
    public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                5,
                6,
                8
        };
        int output = mySum.Sum(150, set);
        assertEquals(4419, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf5and25UpToTwoHundredSeventyFive() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                5,
                25
        };
        int output = mySum.Sum(51, set);
        assertEquals(275, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOf43and47UpToTenThousand() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                43,
                47
        };
        int output = mySum.Sum(10000, set);
        assertEquals(2203160, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOfOneUpToOneHundred() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
                1
        };
        int output = mySum.Sum(100, set);
        assertEquals(4950, output);

    }


    @org.junit.Test
    public void testSumOfMultiplesOfNoneUpToTenThousand() {

        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {};
        int output = mySum.Sum(10000, set);
        assertEquals(0, output);

    }

    public static Test suite() {
        return new TestSuite(SumOfMultiplesTest.class);
    }
}
