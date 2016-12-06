import java.util.Scanner;
public class Invoice
{
	private String number;
	private String description;
	private int quantity;
	private double price;
	private Scanner scanner = new Scanner(System.in);

	//constructor
	public Invoice(String no,String desc,int qty,double price)
	{
		number = no;
		description = desc;
		quantity = qty;
		price = price;
	}

	/*
	setters and getters
	*/

	//setters and getters for number
	public void setNumber(String num)
	{
		number = num;
	}

	public String getNumber()
	{
		return number;
	}

	//setter and getter for description
	public void setDescription(String desc)
	{
		description = desc;
	}

	public String getDescription()
	{
		return description;
	}


	//setter and getter for quantity
	public void setQuantity(int qty)
	{
		quantity = qty;
	}

	public int getQuantity()
	{
		return quantity;
	}

	//setter and getter for price
	public void setPrice(double price)
	{
		price = price;
	}

	public double getPrice()
	{
		return price;
	}

	//method getInvoiceAmount that calculates invoice amount..multiplies the qty by the price and returns the amount
	public void getInvoiceAmount()
	{
		int userQty = getQuantity();
		double userPrice = getPrice();

		double amount = userQty * userPrice;
		System.out.printf("Invoice Amount: %.2f ",amount);
	}
}//end