package CoffeeCheckin;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * CoffeeCheckInSimulation Tester.
 *
 * @author <Brian Lusina>
 * @since <pre>11/18/2016</pre>
 * @version 1.0
 */
public class CoffeeCheckInSimulationTest extends TestCase {
    public CoffeeCheckInSimulationTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(CoffeeCheckInSimulationTest.class);
    }
}
