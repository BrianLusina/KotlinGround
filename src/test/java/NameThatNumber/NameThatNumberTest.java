package test.java.NameThatNumber;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import main.java.Strings.NameThatNumber.NameThatNumber;
import org.junit.After;
import org.junit.Before;


public class NameThatNumberTest extends TestCase {
    public NameThatNumberTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    NameThatNumber name = new NameThatNumber();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: nameThatNumber(int x)
     *
     */
    @org.junit.Test
    public void testTen() throws Exception {
        assertEquals("10 must be supported and return \"ten\"", name.nameThatNumber(10), "ten");
    }

    @org.junit.Test
    public void testNinetyThree() throws Exception {
        assertEquals("93 must be supported and return \"ninety three\"", name.nameThatNumber(93), "ninety three");
    }

    @org.junit.Test
    public void testZero() throws Exception {
        assertEquals("0 must be supported and return \"zero\"", name.nameThatNumber(0), "zero");
    }

    public static Test suite() {
        return new TestSuite(NameThatNumberTest.class);
    }
}
