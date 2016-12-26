package datastructures;

import datastructures.stacks.Stacks;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Stacks Tester.
 *
 * @author <Brian Lusina>
 * @since <pre>12/26/2016</pre>
 * @version 1.0
 */
public class StacksTest extends TestCase {
    public StacksTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(StacksTest.class);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetCurrentSize() throws Exception {
        Stacks stack = new Stacks(2);
        assertEquals("Expected size 2", 2, stack.getCurrentSize());
    }

    public void testIsEmpty(){
        Stacks stack = new Stacks(0);
        assertEquals("Expected an empty stack", true, stack.isEmpty());
    }

    public void testIsFull(){
        Stacks<String> stack = new Stacks<>(2);
        stack.push("Oranges");
        stack.push("Mangoes");
        assertEquals("Expected a full stack", true, stack.isFull());
    }

    public void testPeek(){
        Stacks<String> stack = new Stacks<>(3);
        stack.push("Oranges");
        stack.push("Mangoes");
        stack.push("Apples");
        assertEquals("Expected Apples", "Apples", stack.peek());
    }

    public void testPop(){
        Stacks<String> stack = new Stacks<>(4);
        stack.push("Oranges");
        stack.push("Mangoes");
        stack.push("Apples");
        stack.push("Pawpaws");
        assertEquals("Expected Pawpaws", "Pawpaws", stack.pop());

        assertEquals("Expected size to reduce", 3, stack.getCurrentSize());
    }

    public void testPush(){
        Stacks<String> stack = new Stacks<>(4);
        stack.push("Phone");
        stack.push("Tablet");
        stack.push("Laptop");
        assertEquals("Expected Last added element to be Laptop", "Laptop", stack.peek());
    }
}
