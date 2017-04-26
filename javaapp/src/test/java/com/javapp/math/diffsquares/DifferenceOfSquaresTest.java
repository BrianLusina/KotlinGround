package com.javapp.math.diffsquares;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * com.javapp.math.diffsquares
 * Created by lusinabrian on 27/02/17.
 * Description: Tests for {@link DifferenceOfSquares}
 */

public class DifferenceOfSquaresTest {
    @Test
    public void testSquareOfSum5() {
        final int expected = 225;
        final int actual = DifferenceOfSquares.computeSquareOfSumTo(5);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testSquareOfSum10() {
        final int expected = 3025;
        final int actual = DifferenceOfSquares.computeSquareOfSumTo(10);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testSquareOfSum100() {
        final int expected = 25502500;
        final int actual = DifferenceOfSquares.computeSquareOfSumTo(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquares5() {
        final int expected = 55;
        final int actual = DifferenceOfSquares.computeSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testSumOfSquares10() {
        final int expected = 385;
        final int actual = DifferenceOfSquares.computeSumOfSquaresTo(10);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testSumOfSquares100() {
        final int expected = 338350;
        final int actual = DifferenceOfSquares.computeSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testDifferenceOfSquaresOfSquares0() {
        final int expected = 0;
        final int actual = DifferenceOfSquares.betweenSquareOfSumAndSumOfSquaresTo(0);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testDifferenceOfSquaresOfSquares5() {
        final int expected = 170;
        final int actual = DifferenceOfSquares.betweenSquareOfSumAndSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    
    @Test
    public void testDifferenceOfSquaresOfSquares10() {
        final int expected = 2640;
        final int actual = DifferenceOfSquares.betweenSquareOfSumAndSumOfSquaresTo(10);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresOfSquares100() {
        final int expected = 25164150;
        final int actual = DifferenceOfSquares.betweenSquareOfSumAndSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }
}
