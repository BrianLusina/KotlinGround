
//this imports the Scanner class from the java.util library and is used to obtain user input
import java.util.Scanner;

//this imports the JOptionPane class from the javax.swing library that will be used to create pane for user input
import javax.swing.JOptionPane;

public class MyTutorial{

public static void main(String[] args){

	//this creates integer variables which store integers ,eg 2,4
	int fnum,snum,firstAns;
	fnum = 2;
	snum = 3;
	firstAns = fnum + snum;
	//the result should be 5
	System.out.println("The resultant sum of snum and fnum is " + firstAns);

	//double variable stores large numbers which have decimal places such as 6.7 8.9
	double firstNum,secondNum,secondAns;
	firstNum = 5.5;
	secondNum = 4.3;
	secondAns = firstNum + secondNum;

	//the resultant answer should be 9.8
	System.out.println("The answer is " + secondAns);

	//short variables work in the same way as integer variables
	/*
	short shortNumOne, shortNumTwo, shortAns;
	shortNumOne = 5;
	shortNumTwo = 7;
	shortAns = shortNumOne + shortNumTwo;

	//the answer should be 12
	System.out.println("The answer is " + shortAns);
	*/

	//float variables work in the same way as double variables but the assignment value should have a letter f before the semicolon
	float floatNumOne,floatNumTwo,floatAns;

	//note the f after the numbers 3.7 and 20.6
	floatNumOne = 3.7f;
	floatNumTwo = 20.6f;
	floatAns = floatNumOne + floatNumTwo;

	//the answer should be 24.3
	System.out.println("The answer is " + floatAns);

	//string variables store strings or phrases or words. the words have to be enclosed in double quotes
	String firstWord = "Amazing";
	String secondWord = "Stuff";

	//the output should be Amazing Stuff
	System.out.println(firstWord + " " + secondWord);

	//the char variable is used to store single characters or letters
	char letter = 'B';

	System.out.println("My name starts with a letter " + letter);

	//obtaining user input
	/*the user input is obtained using the scanner class which has already been imported from the java.util library
	1.to use the class 1st create a new object from the scanner class
		Scanner nameOfScannerObject = new Scanner(System.in);
		-nameOfScannerObject is obviously the name of the scanner object
		-new is a keyword used to let Java know that you are creating a 'new' scanner called nameOfScannerObject
		-System.in refers to System input
	2.you can use the scanner object to obtain data from the user as follows
	*/

	//create scanner object
	Scanner userInput = new Scanner(System.in);

	//create a String variable called fname or whatever you like
	String fName, sName;

	//prompt user for first name
	System.out.print("Please enter first name: ");

	/*next is used to store the 'next string that the user inputs on their keyboard'*/
	//store the user's input in the scanner object

	fName = userInput.next();

	//request user for second name
	System.out.print("Enter second name: ");

	sName = userInput.next();

	//you can now create a new variable called fullNames using the user input
	String fullName;
	fullName = fName + " " + sName;

	//tell the user their full name
	System.out.println("Your full name is: " + fullName);


	//another way to obtain user input is through using option panes

	//create variables
	String hobby;
	String like;

	//show input dialog boxes to user so as to obtain user input from user and assign them to above variables
	hobby = JOptionPane.showInputDialog("Hobby" ,"What is your hobby?");
	like = JOptionPane.showInputDialog("Likes", "What do you like?");

	//show the message box to user
	String hobbyAndLike;
	hobbyAndLike = "Your hobby is " + hobby + " and you like " + like;

	JOptionPane.showMessageDialog(null, hobbyAndLike);

	JOptionPane.showMessageDialog(null, hobbyAndLike, "Name", JOptionPane.INFORMATION_MESSAGE);

	//if statements
	/*
	If statements are executed when a certain condition is met and if the condition is not met then
	the code will not be executed. the synax
	if(contion){
		//do something here
		}
	*/

	if(8>2){
		System.out.println("This is an if statement and the conditon has been met. That is 8 is greater than 2");
		}

	/*If else statements
	the if else statements work in the same way, but if one condition is not met
	then another block of code will be executed
	*/

	if(2>3){
		System.out.println("This is obviously a lie 2 can never be greater than 3. This will not be executed");
		}
		else
		{
			System.out.println("2 is not greater than 3, hence this code has been executed");
		}

	/*if else if
	this is used to test many conditions at once. if the 1st condition is not met then the 2nd condition
	is tested for and if that is not met then the 3rd condtion is tested and if that is not met then the 4th and so on and so forth.
	if none of them is satisfied then the last block of code is executed
	*/

	if(5>9)
	{
		System.out.println("5 is not greater than 9, hence this will not be executed");
	}
	else if(1 == 0)
	{
		System.out.println("1 is not equal to 0 hence this will not be executed either");
	}
	else
	{
		System.out.println("none of the above has been met, so here I am!");
	}

/*the switch statement
This statement allows the programme to test multiple variations of the variable and is more convenient
to use as compared to the if else statements
the syntax
switch(variable to test){
	case value;
		//code;
		break;

			case value:
			//code;
			break;
				.
				.
				.
				default:
					//code to execute if none of the values above is caught
					}
the default part of the code is optional.
*/

//variable to test
int age;
	Scanner userAge = new Scanner(System.in);
	System.out.println("How old are you?");
	age = userAge.nextInt();
	//switch statement
	switch(age){
		case 27:
			System.out.println(age + " is between 21 and 30");
			break;

			case 25:
				System.out.println(age + " years old, just above 21");
				break;

				case 30:
					System.out.println(age + "years huh? mid-life crisis? no?");
					break;

					default:
						System.out.println("I dont even know why you are here. youre too grown");
	}

//create variables
String color;
String team;
Scanner userColor = new Scanner(System.in);
Scanner userTeam = new Scanner(System.in);
//prompt user for color
System.out.print("Which color do you pick between Red, Blue, Black or White");

//store user input
color = userColor.next();

//create if else
if(color.equals("Red"))
{
	System.out.println("Ah! a Reds fan! Liverpool or Manchester United?");
	team = userTeam.next();
	if (userTeam.equals("Liverpool")){
		System.out.println("I like Liverpool, its an amazing team");
		}else if(userTeam.equals("Manchester United")){
			System.out.println("I respect Manchester United");
			}
}
	else if(color.equals("Blue"))
	{
		System.out.println("Do you like Chelsea?");
	}
	else if(color.equals("Black"))
	{
		System.out.println("Why Black? does it go with your eyes?");
	}
	else if(color.equals("White"))
	{
		System.out.println("Interesting, you must like peace");
	}
	else
	{System.out.println("Please pick either Black, White, Red, Blue or Black");
	}


/*For loops
	these loops execute lines of code from a certain start point and upto an end point and with a certain increment
	for(startValue;endValue;incrementValue)
	{
		//code
	}

*/

//declare variables
int start;
int end = 5;

//begin for loop
for(start = 0;start<end;start++)
{
	System.out.println("This loop starts at " + start + " and ends at " + end);
}

//multiplication table
//declare variables
int userNum;
int endNo = 10;
int num;
Scanner userNo = new Scanner(System.in);

//prompt user
System.out.println("Which multiplication table do you want?");

//store user number
userNum = userNo.nextInt();

//begin for loop
for(num = 1; num<=endNo; num++)
{
	System.out.println( num + " times " + userNum + " is " + userNum*num);
}

/*while loop
	these loops go through code while the condition is true and exits when the condition is no longer true
	while(condition)
	{
		//code
		//there has to be a provision for the code to evalute to false otherwise it will loop forever
	}

*/
int loopVal = 0;

while(loopVal<5)
{
	System.out.println("My Name is Brian!!");
	loopVal++;
}

/*Do While
this code loops in the same was as while but there is a difference in syntax and also how the code is executed
this code performs a certain command while the condition is true and exits immediately it becomes false. thie means
that there needs to be a provision to exit the code otherwise it will loop forever

do
{
	//code
	//provision to exit code e.g. increment of variable
}
while(condition)

*/
do{
	System.out.println("My Name is Brian!!");
	loopVal++;
	}while(loopVal <5);












	//end of code
	}
}