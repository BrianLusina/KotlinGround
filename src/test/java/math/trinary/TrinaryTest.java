package test.java.trinary;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import main.java.trinary.Trinary;


public class TrinaryTest extends TestCase {
    public TrinaryTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void testNonTrinaryCharacterIsZero() {
        assertEquals(0, Trinary.toDecimal("-"));
    }

    @org.junit.Test
    public void testNonTrinaryNumberIsZero() {
        assertEquals(0, Trinary.toDecimal("3"));
    }

    @org.junit.Test
    public void testTrinaryWithNonTrinaryIsZero() {
        assertEquals(0, Trinary.toDecimal("102-12"));
    }

    @org.junit.Test
    public void testTrinary() {
        assertEquals(302, Trinary.toDecimal("102012"));
    }
    public static Test suite() {
        return new TestSuite(TrinaryTest.class);
    }
}
