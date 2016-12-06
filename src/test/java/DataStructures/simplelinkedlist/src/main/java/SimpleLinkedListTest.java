package test.DataStructures.simplelinkedlist.src.main.java;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * SimpleLinkedList Tester.
 *
 * @author <Authors name>
 * @since <pre>12/06/2016</pre>
 * @version 1.0
 */
public class SimpleLinkedListTest extends TestCase {
    public SimpleLinkedListTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(SimpleLinkedListTest.class);
    }
}
