package com.javapp.ReverseString;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


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
