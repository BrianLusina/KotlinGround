package FunctionalProg.Student;
import FunctionalProg.StudentPojo;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * FunctionalProg.StudentPojo
 * Created by lusinabrian on 14/11/16.
 * Description:
 */
public class StudentFunctionalTests {
    @Test
    public void testJohnSmith() throws Exception {
        StudentPojo jSmith = new StudentPojo("John", "Smith", "js123");
        assertTrue("John Smith with student number js123 did not return true", StudentFunctProgram.f.apply(jSmith));
    }
}
