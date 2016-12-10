package test.java.ReverseString;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;


public class ReverseTest extends TestCase {
    public ReverseTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(ReverseTest.class);
    }
}
