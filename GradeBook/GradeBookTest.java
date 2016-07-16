import java.util.Scanner;

public class GradeBookTest
{
	public static void main(String[] args)
	{
		//Scanner variable
		Scanner userIn = new Scanner(System.in);
		//or java.util.Scanner userIn = new java.util.Scanner(System.in);

		//instantiate the class GradeBook
		GradeBook myGradeBook = new GradeBook("Java","Brian Lusina");

		//display the initial course name, which should be blank
		System.out.printf("Initial Course name is: %s\n", myGradeBook.getCourseName());
		System.out.printf("Taught by %s\n",myGradeBook.getInstructor());

		//prompt
		System.out.print("Please enter the name of the course: \n");
		//store user choice in Scanner variable
		String nameOfCourse = userIn.nextLine();
		//set the name of the course the user inputs
		myGradeBook.setCourseName(nameOfCourse);

		//call the method from the class GradeBook to display the message
		myGradeBook.displayMessage();

	}//Main Method END
}//Class End