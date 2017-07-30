package com.javapp.math.diffsquares;

import java.util.stream.IntStream;

/**
 * com.javapp.math.diffsquares
 * Created by lusinabrian on 27/02/17.
 * Description:
 */
public final class DifferenceOfSquares {

  /**
   * computes the square of the sum of N natural numbers
   *
   * @param limit the limit or number of natural numbers to compute
   * @return square of the sum of N natural numbers as an {@link Integer}
   */
  public static int computeSquareOfSumTo(int limit) {
    return (int) Math.pow(IntStream.rangeClosed(1, limit).sum(), 2);
  }

  /**
   * Computes the sum of squares of N natural number, will square each natural number and sum to to
   * a total
   *
   * @param limit the limit or number of N natural numbers
   * @return the sum of squares of N natural numbers as an {@link Integer}
   */
  public static int computeSumOfSquaresTo(int limit) {
    int total = 0;
    for (int x = 1; x <= limit; x++) {
      total += Math.pow(x, 2);
    }
    return total;
  }

  public static int betweenSquareOfSumAndSumOfSquaresTo(int num) {
    return computeSquareOfSumTo(num) - computeSumOfSquaresTo(num);
  }

}
