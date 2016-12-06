import java.util.Scanner;
import javax.swing.JOptionPane;

public class NameSwapGame
{
	public static void main(String[] args)
	{
		// create variables
		String userName;
		Scanner userInput = new Scanner(System.in);

		//prompt the user for their full name
		System.out.println("Please enter your full name");

		//store user's name in userInput variable
		userName = userInput.nextLine();


		//grab the first 2 characters of the user's name
		String firstNameChars = "";
		firstNameChars = userName.substring(0,2);


		//find the position of the space bar
		int spacePos = userName.indexOf(" ");

		//grab the first two characters of surname
		String surNameChars = "";
		surNameChars = userName.substring(spacePos+1,(spacePos+1)+2);

		//grab the other first Name characters of the user's name
		String otherFirstNameChars = "";
		otherFirstNameChars = userName.substring(2,spacePos);

		//grab the other last name characters of the user's name
		String otherLastNameChars = "";
		otherLastNameChars = userName.substring(spacePos+3, userName.length());

		//swap the names
		String newName = firstNameChars + otherLastNameChars + " " + surNameChars + otherFirstNameChars;

		System.out.println("Your new name is " + newName );










//end of code
	}
}