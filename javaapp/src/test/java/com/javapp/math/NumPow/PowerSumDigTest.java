package com.javapp.math.NumPow;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * PowerSumDig Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/08/2016</pre>
 */
public class PowerSumDigTest {

  private static void testing(long act, long exp) {
    assertEquals(exp, act);
  }

  @Test
  @Ignore
  public void test1() {
    testing(PowerSumDig.powerSumDigTerm(1), 81);
    testing(PowerSumDig.powerSumDigTerm(2), 512);
    testing(PowerSumDig.powerSumDigTerm(3), 2401);
    testing(PowerSumDig.powerSumDigTerm(4), 4913);
  }

}
