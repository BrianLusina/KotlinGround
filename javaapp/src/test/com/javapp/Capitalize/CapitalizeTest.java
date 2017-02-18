package com.javapp.Capitalize;

import com.javapp.stringswords.Capitalize.Capitalize;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;

public class CapitalizeTest extends TestCase {
    public CapitalizeTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    Capitalize cap = new Capitalize();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: capitalize(String str)
     */
    @org.junit.Test
    public void test_single_word() throws Exception {
        assertEquals("Men", cap.capitalize("men"));
    }

    @org.junit.Test
    public void test_many_words() throws Exception{
        assertEquals("Men Men Men Menly Men Men", cap.capitalize("men men men menly men men"));
    }

    @org.junit.Test
    public void test_two_words() throws Exception{
        assertEquals("I Am", cap.capitalize("i am"));
    }

    public static Test suite() {
        return new TestSuite(CapitalizeTest.class);
    }
}
