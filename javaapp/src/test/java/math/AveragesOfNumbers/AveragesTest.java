package java.math.AveragesOfNumbers;

import junit.framework.TestCase;

import java.math.AveragesOfNumbers.Averages;
import java.util.Arrays;

public class AveragesTest extends TestCase {
    public AveragesTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void basicTests(){
        assertEquals(Arrays.toString(new double[] { 2, 2, 2, 2 }), Arrays.toString(Averages.averages(new int[] { 2, 2, 2, 2, 2 })));
        assertEquals(Arrays.toString(new double[] { 0, 0, 0, 0 }), Arrays.toString(Averages.averages(new int[] { 2, -2, 2, -2, 2 })));
        assertEquals(Arrays.toString(new double[] { 2, 4, 3, -4.5 }), Arrays.toString(Averages.averages(new int[] { 1, 3, 5, 1, -10 })));
    }
}
