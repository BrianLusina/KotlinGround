package FunctionalProg.Student1;

import FunctionalProg.StudentPojo;

import java.util.function.Function;

/**
 * FunctionalProg.StudentPojo
 * Created by lusinabrian on 14/11/16.
 * Description:
 */
public class FunctionalProgramming {

    //Make me a function; remember to set the types!
    public static Function<StudentPojo, Boolean> f = studentPojo ->
            studentPojo.getFullName().equals("John Smith") && studentPojo.studentNumber.equals("js123");

}
