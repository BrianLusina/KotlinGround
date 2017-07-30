package com.javapp.math.trinary;

/**
 * Created by lusinabrian on 15/08/16 or 15 Aug of 2016,
 * Time: 14:40.
 * Project: java.java.math.trinary
 */
public class Trinary {

  private static final int RADIX = 3;

  public static int toDecimal(String trin) {
    if (!validTrinary(trin)) {
      return 0;
    }

    int power = 1;
    int n = 0;

    for (int i = trin.toCharArray().length - 1; i >= 0; i--) {
      int dig = Character.digit(trin.charAt(i), RADIX);
      n += dig * power;
      power *= RADIX;
    }
    return n;
  }/*method end*/

  public static boolean validTrinary(String s) {
    return s.matches("[012]+");
  }
/*CLASS END*/
}