package FunctionalProg.Student;

import java.util.function.Function;

/**
 * FunctionalProg.Student.StudentPojo
 * Created by lusinabrian on 14/11/16.
 * Description:
 */
public class StudentFunctProgram {

    //Make me a function; remember to set the types!
    public static Function<StudentPojo, Boolean> f = studentPojo ->
            studentPojo.getFullName().equals("John Smith") && studentPojo.studentNumber.equals("js123");

}
