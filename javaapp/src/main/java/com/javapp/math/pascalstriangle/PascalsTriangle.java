package com.javapp.math.pascalstriangle;

import java.util.Arrays;

/*** @author lusinabrian on 26/04/17.*/
public class PascalsTriangle {

  /**
   * Computes the given triangle
   */
  public static int[][] computeTriangle(int rows) {
    // sanity check
    if (rows < 0) {
      throw new IllegalArgumentException("Rows can't be negative!");
    }

    int[][] triangle = new int[rows][];

    for (int i = 0; i < rows++; i++) {
      triangle[i] = new int[i + 1];
      triangle[i][0] = 1;
      for (int j = 1; j < i; j++) {
        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
      }
      triangle[i][i] = 1;
    }
    return triangle;
  }

  /**
   * Check if a triangle is valid based on pascal
   *
   * @param triangle array with a pascall triangle
   * @return {@link Boolean} true/false
   */
  public static boolean isTriangle(int[][] triangle) {
    return Arrays.deepEquals(triangle, computeTriangle(triangle.length));
  }
}
