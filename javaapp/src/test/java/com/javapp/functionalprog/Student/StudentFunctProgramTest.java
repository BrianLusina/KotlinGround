package com.javapp.functionalprog.Student;

import junit.framework.TestCase;


public class StudentFunctProgramTest extends TestCase {
    public StudentFunctProgramTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void testJohnSmith() throws Exception {
        StudentPojo jSmith = new StudentPojo("John", "Smith", "js123");
        assertTrue("John Smith with student number js123 did not return true", StudentFunctProgram.f.apply(jSmith));
    }

}
