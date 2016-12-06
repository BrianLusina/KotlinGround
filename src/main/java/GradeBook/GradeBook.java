public class GradeBook
{
	private String courseName;
	private String instructor;
	//constructor
	public GradeBook(String name, String instructorName)
	{
		courseName = name;
		instructor = instructorName;
	}

	//method to set the intructor's name
	public void setIntructor(String instructorName)
	{
		instructor = instructorName;
	}

	//method to get the instructor name
	public String getInstructor()
	{
		return instructor;
	}
	//method to set the course name
	public void setCourseName(String name)
	{
		courseName = name;
	}

	//method to retrieve the course name
	public String getCourseName()
	{
		return courseName;
	}

	//method to display a message when the user opens the Grade Book app
	public void displayMessage()
	{
		System.out.printf("Welcome to the Grade Book for \n%s!\n", getCourseName());
		System.out.printf("Your instructor is \n%s\n", getInstructor());
	}

}//Class End