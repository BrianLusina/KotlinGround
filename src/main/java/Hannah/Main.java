package main.java.Hannah;

import java.util.Scanner;

/**
 *Created by lusinabrian on 29/11/15.
 Project: Hannah,
 Package: ${PACKAGE_NAME}
 */
public class Main {
    public static void main(String[] args){
        //Scanner object to obtain input
        Scanner scanner = new Scanner(System.in);

        //integer variables to store the integers
        int num1,num2,sum;

        /*Introduction*/
        System.out.println("Welcome, I am Hannah and I shall guide you through my various features");
        System.out.println("I am not as complex as I appear even though I am sophisticated. All you have to do is sit back and follow my simple guidelines.");
        System.out.println("Remember; I am here to serve you.");

        System.out.println("I am your personal assistant or if you prefer your PA (short for personal assistant). I perform many tasks:\n" +
                " I fetch your mail, \n" +
                " Get you the latest news, \n" +
                " Keep you up to date with your social media accounts (assuming you have them), \n" +
                " Also keep you posted on the latest shows of your liking (also assuming you watch television), \n" +
                " And of course make sure you do not miss your various appointments (hoping you will have several of them :))" );
        System.out.println("These are not the limitations to my capabilities as I can also hack into nuclear warheads and cause world destruction. I lie of course, that was to get your attention");
        System.out.println("\n");
        System.out.printf("%s","This should be exciting! I look forward to our new found friendship and partnership.");

        System.out.println("Let us start with a simple math to test my skill. You know, for the lulz :)");

        /*Prompt*/
        System.out.println("Give me two numbers! Don't be shy!");
        System.out.printf("%s\n","First is: ");
        num1 = scanner.nextInt(); //get the first integer and store it in the scanner object

        System.out.printf("%s\n","Got it. How about the second? ");
        num2 = scanner.nextInt(); //do the same for the second integer

        System.out.printf("%s\n","Awesome! Now let me get back to you in a jiffy. ");
        sum = num1 + num2; //add the numbers obtained

        System.out.printf("And the sum is %d\n",sum);

        System.out.printf("%s\n","See! That was easy. I can do basic math in case you need to calculate how much you owe your bookie :)");

        System.out.println("Before we proceed, there is something I have to tell you. I am quite the health expert. Don't believe me?\n");
        System.out.printf("%s\n","Give me your weight in kilograms and your height in meters. Don't be shy, I will not tell a soul.");
        System.out.printf("%s\n","First, your weight: ");
        double weight = scanner.nextDouble();

        System.out.printf("%s\n","Now, how sho...err...tall are you?");
        double height = scanner.nextDouble();
        double BMI = weight/height*height;

        System.out.printf("%s\n","Your Body Mass Index (BMI) is...drum rolls: ");
        System.out.println(BMI);

        String bmiComment;
        if (BMI < 18.50) {
            bmiComment = "Underweight";
            System.out.println("Which means you are " + bmiComment + " You need to bulk up or you will shrivel!");
        }else if(BMI>=18.5 || BMI <24.9){
            bmiComment = "Normal";
            System.out.println("Which means you are " + bmiComment + " You are cool, Keep doing what it is you do, but stay healthy");
        }else if(BMI >= 25 || BMI < 29.9){
            bmiComment = "Overweight";
            System.out.println("Which means you are " + bmiComment + " Beyond the normal weight you should be. Eat right and hit the gym");
        }else if(BMI == 30 || BMI >30){
            bmiComment = "obese";
            System.out.println("Which means you are " + bmiComment + " Please seek medical attention as this is dangerous to your health.");
        }
    }//END of main
}//END