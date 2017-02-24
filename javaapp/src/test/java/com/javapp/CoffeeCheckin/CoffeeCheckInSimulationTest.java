package com.javapp.CoffeeCheckin;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * CoffeeCheckInSimulation Tester.
 *
 * @author <Authors name>
 * @since <pre>12/07/2016</pre>
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
