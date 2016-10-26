/*shop details:
1.minimum of 5 items in shop
2.user should input the number of each partiular item they intend to purchase (qty)

Program details:
1.use of prompt to ask user how many items they intend to purchase
2.the price should be in a primitive data type of double as currency has decimal usually
3.calculate the total price of the items and display to user
4.thank customer for shopping
*/

//import Java package to obtain user input
import java.util.Scanner;

//begin code
public class MyShop
{

	//create main method
	public static void main(String[] args)
	{
		//create an array of items using an array initializer that will store names of the items in the shop

		int item1, item2, item3, item4, item5;

		item1=1;
		item2=2;
		item3=3;
		item4=4;
		item5=5;

		int stock[] = {item1,item2,item3,item4,item5};


		//create an array of prices that will correspond with each item in the items array
		double prices [] = new double[5];

		prices[0] = 35.20;
		prices[1] = 100.50;
		prices[2] = 55.30;
		prices[3] = 68.60;
		prices[4] = 99.90;

		//create variables that will store quantitity and items selected
		int item;
		int qty;

		//create scanner variable to save user's input or decision
		Scanner userDecision = new Scanner(System.in);

		//welcome customer to the shop and ask for what they want
		System.out.println("Welcome to MyShop at Java, what is your order?");
		System.out.println("Type in 1 for Sugar,2 for flour,3 for bread,4 for rice and 5 for eggs");

		//store the user's decision in a variable
		item = userDecision.nextInt();

		//begin if else if statement to loop over possibilities and ask user what quantities they require for the items
		if(item == 1)
		{
			System.out.println("How many packets of Sugar do you require?");
			}
			else if(item == 2)
			{
				System.out.println("How many kilograms of flour do you require?");
				}
				else if(item == 3)
				{
					System.out.println("How many loaves of bread do you require?");
					}
					else if(item == 4)
					{
						System.out.println("How many kilograms of rice do you require?");
						}
						else if(item == 5)
						{
							System.out.println("How many trays of eggs do you require?");
							}
							else
							{
								System.out.println("Please select a choice between 1 and 5");
								}

		//store quantity in a variable
		qty = userDecision.nextInt();


		//calculate how much it will cost the user to purchase the items by using a switch statement
		switch(item)
		{
			case 1:
				System.out.println("that will cost" + prices[0]*qty);
				System.out.println("Thank you for shopping with us, proceed to checkout");
			break;

			case 2:
				System.out.println("that will cost" + prices[1]*qty);
				System.out.println("Thank you for shopping with us, proceed to checkout");
			break;

			case 3:
				System.out.println("that will cost" + prices[2]*qty);
				System.out.println("Thank you for shopping with us, proceed to checkout");
			break;

			case 4:
				System.out.println("that will cost" + prices[3]*qty);
				System.out.println("Thank you for shopping with us, proceed to checkout");

			break;

			case 5:
				System.out.println("that will cost" + prices[4]*qty);
				System.out.println("Thank you for shopping with us, proceed to checkout");

			break;

			default:
			System.out.println("Please select an item and the quantity you wish to purchase");
			break;

		}

		}

}