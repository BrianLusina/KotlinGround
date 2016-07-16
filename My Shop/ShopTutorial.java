//import Java package Scanner to store User input in Scanner variable
import java.util.Scanner;

public class ShopTutorial{
	//begin main method
	public static void main(String[] args){

		//declare variables to use during entire code
		//create an object of type scanner

		Scanner userInput = new Scanner(System.in);

		//ask user how mnay items they need
		System.out.println("How many items do you need?");

		//store user input in scanner variable
		int items = userInput.nextInt();

		//create the array for prices
		double[] prices = new double[items];


		//create an array of quantity of the items
		int[] qty = new int[items];

		//create an array for the name of the items
		String[] itemNames= new String[items];

		//create a variable of data type double to store the total amount of the purchase
		double total=0.0;

		//begin for loop to loop over user items required
		for(int i =0;i<items;i++){

			//request user to enter the name of the purchase
			System.out.println("Enter the name of item ");
			itemNames[i]= userInput.next();

			//request user to input the cost of the item
			System.out.printf("Enter the unit cost of %s\n ", itemNames[i]);

			//store the user input in the prices array
			prices[i] = userInput.nextDouble();


			//request user the quantity of the item they intend to purchase
			System.out.printf("Enter the quantity of %s\n ",itemNames[i]);

			//store user input in qty array
			qty[i] = userInput.nextInt();

			//calculte the total price of the items purchased
			total+=prices[i]*qty[i];
			}

			//loop to print the details of the items
			int index=0;
			while(index<items){

				//output full details about the customer purchase
				System.out.printf("%s\t%2f\t%d\n",itemNames[index],prices[index],qty[index]);
				index++;

				}

			//show the total amount of the items purchased
			System.out.printf("The total is %.2f\n",total);



		}
	}