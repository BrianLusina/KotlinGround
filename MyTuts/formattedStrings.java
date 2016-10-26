public class formattedStrings
{
	public static void main(String[] args)
	{
		//%s formats the String Total: and %d formats the number 245321
		System.out.printf("%s,%d,%n", "Total: ", 245321);

		//formats the number to 10 places to the left as padding
		System.out.printf("%s,%10d,%n", "Total: ", 245321);

		//print out two sets of numbers.. the first number is left justified, the second one is right justified
		System.out.printf("%-10d,%10d,%n", 256451, 245321);


		//the first number is padded with zeros to the left and the second number is right justified
		System.out.printf("%010d,%10d,%n", 13543, 245321);

		//floating point number formating
		System.out.printf("%f,%n", 2453.21);

		//formats the floating point number to 2 decimal places
		System.out.printf("%.2f,%n", 2453.21);

		//an example

		//declare variables
		String heading1, heading2, course1, course2, course3, grade1, grade2, grade3;
		heading1 = "Exam Name" ;
		heading2 = "Exam Grade" ;
		course1 = "Java" ;
		course2 = "PHP" ;
		course3 = "HTML" ;
		grade1 = "A" ;
		grade2 = "B" ;
		grade3 = "A" ;

		System.out.println();
		System.out.printf("%-15s,%15s,%n",heading1,heading2);
		System.out.println("--------------------------------------------------");

		System.out.printf("%-15s,%10s,%n",course1,grade1);
		System.out.printf("%-15s,%10s,%n",course2,grade2);
		System.out.printf("%-15s,%10s,%n",course3,grade3);




//end of code
	}
}