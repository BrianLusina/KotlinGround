package main.java.strain;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Strain Tester.
 *
 * @author <Authors name>
 * @since <pre>12/10/2016</pre>
 * @version 1.0
 */
public class StrainTest extends TestCase {
    public StrainTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(StrainTest.class);
    }
}
