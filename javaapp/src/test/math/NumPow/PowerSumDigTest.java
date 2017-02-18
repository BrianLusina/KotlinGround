package main.java.Math.NumPow;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

/**
 * PowerSumDig Tester.
 *
 * @author <Authors name>
 * @since <pre>12/08/2016</pre>
 * @version 1.0
 */
public class PowerSumDigTest extends TestCase {
    public PowerSumDigTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
    @org.junit.Test
    public void test1() {
        testing(PowerSumDig.powerSumDigTerm(1), 81);
        testing(PowerSumDig.powerSumDigTerm(2), 512);
        testing(PowerSumDig.powerSumDigTerm(3), 2401);
        testing(PowerSumDig.powerSumDigTerm(4), 4913);
    }

}
