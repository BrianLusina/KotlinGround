import java.util.Scanner;
import javax.swing.JOptionPane;

public class StringManipulation
{
	public static void main(String[] args)

	{
		/*Text can be converted to either upper case or lower case using toUpperCase and toLowerCase methods
		this can be useful in entry by user when using some applications, so that they can enter the text without
		worry of entering either in upper case or lower case
		*/

		String upperTxt = "Brian";

		//at first the text will be as input above
		System.out.println(upperTxt);

		//when using toUpperCase, the text will convert to uppercase
		System.out.println(upperTxt.toUpperCase());

		//toLowerCase works in exactly the same way

		String lowerTxt = "LUSINA";

		System.out.println(lowerTxt);

		System.out.println(lowerTxt.toLowerCase());

		/*compareTo method
		used to compare one string of text to another
		example:

		int result;
		String Word1= "Ape";
		String Word2 = "App";

		result = Word1.compareTo(Word2);

		The compareTo method returns a value.
		The value that is returned will be greater than 0, less than 0, or have a value of zero.
		If Word1 comes before Word2, then the value that is returned will be less than 0.
		If Word1 comes after Word2 then the value returned will be greater than 0.
		If the two words are identical then a value of 0 will be returned.

		However, when you compare one string of text with another, Java compares the underlying hexadecimals values,
		rather than the actual letters. Because uppercase letters have a lower hexadecimal value than lowercase ones,
		an uppercase letter "A" in "App" will come before a lowercase letter "a" in "ape".
		To solve the problem, there's a related method called compareToIgnoreCase. As its name suggest, lowercase and uppercase letter are ignored.
		Use this and "ape will come before "App" alphabetically.
		*/

		int result;
		String Word1= "Ape";
		String Word2 = "App";

		result = Word1.compareTo(Word2);

		if(result <0)
		{
			System.out.println("Word1 comes before Word2, i.e. " + Word1 + " comes before " + Word2);
		}
		else if(result>0)
		{
			System.out.println("Word2 comes before Word1 i.e." + Word2 + " comes before " + Word1);
		}
		else if(result == 0)
		{
			System.out.println("Word1 and Word2 are similar i.e. " + Word1 + " and " + Word2 + " are equal");
		}

		/*indexOf method
		used to locate a character or string of text. it returns a value and it will be the position of the string or character
		you are searching for. if it returns -1,it means the character or string is not in the text you are searching for.

		syntax

		stringName.indexOf(textToSearchFor , posToStartAt);

		here the stringName is the name of the text you intend to place your search.
		textToSearchFor is the name of the character or string you want to search for
		posToStartAt is the position you want the indexOf method to start counting from. The default value is 0

		*/


		//this is a basic program to search for the ampersand character '@' in an email address based on what the user inputs as their email addres
		char ampersand = '@';
		String email;

		//create the scanner object
		Scanner userInput = new Scanner(System.in);

		//prompt the user for their email Address
		email = JOptionPane.showInputDialog("What is your email address?");

		int output = email.indexOf(ampersand);

		if(output == -1)
		{
			System.out.println("email address is invalid");
		}
		else
		{
			System.out.println("Valid email address. Your email address is " + email);
		}


		//indexOf can also be used to search for longer string of texts
		String dotCom = ".com";
		String email2 = JOptionPane.showInputDialog("What is your email address?");

		int output2 = email2.indexOf(dotCom);


		if(output2 == -1)
		{
			System.out.println("email address is invalid");
		}
		else
		{
			System.out.println("Valid email address. Your email address is " + email2);
		}

/*
//to start at a different positoin other than 0

String email3;



email3 = JOptionPane.showInputDialog("What is your email address");

int posAt = email3.indexOf(ampersand);

int output3 = email3.indexOf(dotCom , posAt);

if(output3 == -1)
{
	System.out.println("email address is invalid");
}
else
{
	System.out.println("Valid email address. Your email address is " + email3 + " " + posAt);
}
*/


/* ***************************************************************************************************************************************************************************************************************************************************************************************** */

/*
Ends With … Starts With

For the programme above, you can also use the inbuilt method endsWith:

Boolean ending = email_address.endsWith( dotcom );

You need to set up a Boolean variable for endsWith, because the method returns an answer of true or false. The string you're trying to test goes between the round brackets of endsWith, and the text you're searching goes before it. If the text is in the search string then a value of true is returned, else it will be false. You can add an if … else statement to check the value:

if (ending == false ) {
System.out.println( "Invalid Email Address" );
}
else {
System.out.println( "Email Address OK " );
}

The method startsWith is used in a similar way:

Boolean startVal = email_address.startsWith( dotcom );

Again, the return value is a Boolean true or false.
*/


/* ****************************************************************************************************** */

		/*Substrings
		This method allows you to grab one chunk of text from another
		One really useful method available to you is called substring.
		This method allows you to grab one chunk of text from another. In our email address programme above, e.g. we could grab the last five characters from the address and see if it is co.uk.

		To get some practice with substring, we'll write a small Name Swapper game.
		For this game, we want to change the first two letters of a family name and swap them with the first two letters of a personal name,
		and vice versa. So if we have this name:

		"Bill Gates"

		we would swap the "Ga" of "Gates" with the "Bi" of "Bill" to make "Bites". The "Bi" of "Bill" will then be swapped with the "Ga" of "Gates" to make "Gall". The new name printed out would be: "Gall Bites"

		We'll use substring for most of this programme. Substring works like this:

		String FullName = "Bill Gates";
		String FirstNameChars = "";

		FirstNameChars = FullName.substring( 0, 2 );

		You set up a string to search, in this case the string "Bill Gates".
		The string you're trying to search goes after an equals sign. After a dot, type the name of the method, substring.
		There are two ways to use substring, and the difference is in the numbers between the round brackets.
		We have two numbers in the code above, 0 and 2. This means start grabbing characters at position 0 in the string, and stop grabbing when you have two of them.
		The two characters are then returned and placed in the variable FirstNameChars. If you always want to go right to the end of the string, you can just do this:

		String test = FullName.substring( 2 );

		This time, we only have 1 number between the round brackets of substring.
		Now, Java will start at character two in the string FirstName, and then grab the characters from position 2 right to the end of the string.

		*/

		//declare variables
		String fullName = "Brian Lusina";
		String firstNameChars = "";

		//grab only 2 characters from string from position 2 onwards
		firstNameChars = fullName.substring(0,2);

		JOptionPane.showMessageDialog(null, firstNameChars);

		//grab the letters from the first name other than Bi

		String otherFirst = "";
		otherFirst = fullName.substring(2,5);

		JOptionPane.showMessageDialog(null, otherFirst);

/*
//will grab characters from position 4 onwards i.e. "n Lusina"
String test = fullName.substring(4);

JOptionPane.showMessageDialog(null, test);
*/


		String lastNameChars = "";

		//grab the two characters of the name Lusina i.e "Lu"
		lastNameChars = fullName.substring(6, fullName.length()-4); //instead of fullName.length()-4 you can type in 8

		JOptionPane.showMessageDialog(null, lastNameChars);

		//grab the rest of the letters from the surname
		String otherLast = "";
		otherLast = fullName.substring(8,fullName.length());

		JOptionPane.showMessageDialog(null, otherLast);

		//swap the names
		String newName = "";

		newName = firstNameChars + otherLast + " " + lastNameChars + otherFirst ;

		//new name is Brsina Luian
		JOptionPane.showMessageDialog(null, newName);





	//end of code
	}
}