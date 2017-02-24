package com.javapp.math.NumPow;

import junit.framework.TestCase;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * PowerSumDig Tester.
 *
 * @author <Authors name>
 * @since <pre>12/08/2016</pre>
 * @version 1.0
 */
public class PowerSumDigTest{
    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }

    @Test
    public void test1() {
        testing(PowerSumDig.powerSumDigTerm(1), 81);
        testing(PowerSumDig.powerSumDigTerm(2), 512);
        testing(PowerSumDig.powerSumDigTerm(3), 2401);
        testing(PowerSumDig.powerSumDigTerm(4), 4913);
    }

}
