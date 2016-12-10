package main.java.triangle;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Triangle Tester.
 *
 * @author <Authors name>
 * @since <pre>12/10/2016</pre>
 * @version 1.0
 */
public class TriangleTest extends TestCase {
    public TriangleTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetKind() throws Exception {
        //TODO: Test goes here...
    }

    public void testSetGetSide1() throws Exception {
        //TODO: Test goes here...
    }

    public void testSetGetSide2() throws Exception {
        //TODO: Test goes here...
    }

    public void testSetGetSide3() throws Exception {
        //TODO: Test goes here...
    }

    public static Test suite() {
        return new TestSuite(TriangleTest.class);
    }
}
