package FunctionalProg.Triangle;

import java.util.function.Function;

public class TriangleFuncProgram {

    public static Function<Student, Boolean> f = student -> {

        String name = student.getFullName();
        String number = student.studentNumber;

        return (name.equals("John Smith") && number.equals("js123"));
    };

    public static class Student {
        private final String firstName;
        private final String lastName;
        public final String studentNumber;

        public Student(String firstName, String lastName, String studentNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentNumber = studentNumber;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }
        public String getCommaName() {
            return lastName + ", " + firstName;
        }
    }

}