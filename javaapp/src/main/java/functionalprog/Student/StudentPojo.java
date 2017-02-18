package java.functionalprog.Student;


public class StudentPojo {

    public final String studentNumber;
    private final String firstName;
    private final String lastName;

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
