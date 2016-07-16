import java.util.Scanner;


public class Tutorial
{
	public static void main(String[] args)
	{
		//println prints a string and makes the cursor move to the next line
		System.out.println("Welcome to JAVA programming!");
		System.out.println("Here You shall learn dozens of things and apply them in the real world ");

		//prinr does the same thing as above with only difference being the fact that it keeps the cursor at the end of the string
		System.out.print("Exciting huh?");

		System.out.println("As of now, you are reading through these lines expecting something out of the ordinary");

		//printing lines of text within a single statment
		// \n causes a new line character
		System.out.println("Stop \n Doing \n That \n Don't \n expect \n so\n much \n not cool!" );

		//\t horizontal tab moves the screen cursor to the next tab stop
		System.out.println("Since \t we have \t established \t that I will not \t stop bothering you \t and you will not quit \t your habit");

		//\r Carriage return
		System.out.println("Now that we have \r properly been acquainted \r may we proceed?");

		// \\ Backlash used to print a backlash
		System.out.println("Now I know I did not make sense in the previous statement,\\ but come on, You are still hooked \\ so I am doing a fine job");

		// \"\" Double quotes
		System.out.println("Now, I do not mean to be \"impertinent\" by my constant refusal to begin the tutorial, but I do need to mention that I am a \"teacher\" of sorts");

		//using printf or formating os strings
		System.out.printf("%s\n%s\n%s","I say this because I have taught you patience", "this is because you have stuck to the text at hand and are still reading it as we speak","I know, mind-blowing huh?");

		System.out.println("Alright, I have toyed with you enough.\n Now let us really get cracking \n I We shall develop a simple app that adds numbers. \"boring\" I know, but it is very crucial to your learning");

		//create a scanner object
		Scanner userInput = new Scanner(System.in);
		System.out.println("================================Addition==================================");
		//create variables that will hold the user's input
		int num1, num2, sum;

		//create a prompt that will instruct user to input the first number
		System.out.print("Would you be so kind as to enter the first number: ");

		//store the user's number in the variable earlier created
		num1 = userInput.nextInt();

		System.out.print("Now, for the second number: ");
		num2 = userInput.nextInt();

		//add the two numbers
		sum = num1+num2;

		System.out.printf("The sum you seek is %d\n", sum);

		System.out.println("Now that just had to do with addition, we can do several other algebraic expressions as well");

		System.out.println("================================Subtraction==================================");

		//variables
		int sub1,sub2,diff;

		//prompt
		System.out.print("Enter first number,please: ");
		sub1 = userInput.nextInt();
		System.out.print("Now,enter second number,please: ");
		sub2 = userInput.nextInt();

		diff = sub1-sub2;
		System.out.printf("%s\n%d\n","The difference is ",diff);

		System.out.println("================================Division==================================");
		//variables
		int div1,div2,result;

		//prompt
		System.out.print("Enter the quotient please: ");
		div1 = userInput.nextInt();
		System.out.print("Now,enter the dividend: ");
		div2 = userInput.nextInt();

		result = div1/div2;
		System.out.println(div1 + " divided by " + div2 + " is " + result);

		System.out.println("================================Modulus==================================");
		System.out.println("As you have noticed, the result from division ended up showing only the integer part of the division, mostly because it stored it as an integer in the first place. Here we shall use modulus to show only the remainder");

		//variables
		int mod1,mod2,remainder;

		System.out.print("Enter the quotient: ");
		mod1 = userInput.nextInt();
		System.out.print("Now,enter the dividend: ");
		mod2 = userInput.nextInt();

		remainder = mod1%mod2;
		System.out.println(mod1 + " divided by " + mod2 + " has a remainder of " + remainder);

		System.out.println("================================Multiplication==================================");

		//variables
		int prod1,prod2,product;

		System.out.print("1st number: ");
		prod1 = userInput.nextInt();
		System.out.print("2nd number: ");
		prod2 = userInput.nextInt();

		product = prod1*prod2;
		System.out.printf("Product is %d\n ", product);

		System.out.println("================================Comparison==================================");
		System.out.print("Now we are going to make sense of things by making the computer compare the numbers you input and tell you if they are equal or not or if one is greater than the other and/or lesser than \n");
		//variable declarations
		int number1, number2;

		//prompt
		System.out.print("Enter your first number to compare: ");
		number1 = userInput.nextInt();
		System.out.print("Compare your first number to: ");
		number2 = userInput.nextInt();

		System.out.println("this is where the fun begins. The comparison, I mean");

		if(number1 == number2)
		System.out.printf("These two numbers are equal i.e.","%d == %d\n", number1,number2);

		if(number1 != number2)
		System.out.printf("These two numbers are NOT equal i.e.","%d != %d\n", number1,number2);

		if(number1 > number2)
		System.out.printf("Your First number is greater than the second i.e.","%d > %d\n", number1,number2);

		if(number1 < number2)
		System.out.printf("Your First number is less than the second i.e.","%d < %d\n", number1,number2);

		if(number1 >= number2)
		System.out.printf("Your First number is greater than or equal to the second i.e.","%d >= %d\n", number1,number2);

		if(number1 <= number2)
		System.out.printf("Your First number is less than or equal to the second i.e.","%d <= %d\n", number1,number2);

		System.out.println("=====================================Summary=========================================");

		System.out.println("Now we are done with the major part of the tutorial and now we shallmake random star shapes");

		System.out.println("********* \t *** \t * \t *");
		System.out.println("*\t * \t * \t * \t *** \t **");
		System.out.println("*\t * \t * \t * \t ***** \t * \t *");
	}//main method's end
//end
}