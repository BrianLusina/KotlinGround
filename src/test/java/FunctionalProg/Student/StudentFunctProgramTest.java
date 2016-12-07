package test.java.FunctionalProg.Student;

import junit.framework.TestCase;
import main.java.FunctionalProg.Student.StudentFunctProgram;
import main.java.FunctionalProg.Student.StudentPojo;


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
