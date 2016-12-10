package Strings.NameThatNumber;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * NameThatNumber Tester.
 *
 * @author <Authors name>
 * @since <pre>12/10/2016</pre>
 * @version 1.0
 */
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

    public static Test suite() {
        return new TestSuite(NameThatNumberTest.class);
    }
}
