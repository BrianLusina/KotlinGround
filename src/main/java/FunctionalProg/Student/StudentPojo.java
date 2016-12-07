package main.java.FunctionalProg.Student;


public class StudentPojo {

    private final String firstName;
    private final String lastName;
    public final String studentNumber;

    public StudentPojo(String firstName, String lastName, String studentNumber) {
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
