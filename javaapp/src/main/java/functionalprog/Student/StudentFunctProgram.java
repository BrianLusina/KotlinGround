package java.functionalprog.Student;

import java.util.function.Function;

public class StudentFunctProgram {

    //Make me a function; remember to set the types!
    public static Function<StudentPojo, Boolean> f = studentPojo ->
            studentPojo.getFullName().equals("John Smith") && studentPojo.studentNumber.equals("js123");

}
