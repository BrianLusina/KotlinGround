import java.util.Scanner;

//identify the class

public class BankAccount{

//declare the properties

//data members
/*
access-modifier datatype variableName
*/
	private int accountId;
	private String accountName;
	private double balance;
	private int passcode;

//create a Scanner object from Scanner class
Scanner userChoice = new Scanner(System.in);
Scanner userPin = new Scanner(System.in);

//constructor
	public BankAccount(int a,String n,double b, int p){
		accountId = a;
		accountName = n;
		balance = b;
		passcode = p;
	}

//defalt constructor
	public BankAccount(){
		this(0,"Name",0,0 );
	}

//getters and setters

//getters and setters for the account id
	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

		public int getAccountId(){
			return accountId;
			}

//getters and setters for the account name
	public void setAccountName(String accountName){
		this.accountName = accountName;
	}

		public String getAccountName(){
			return accountName;
			}

//getters and setters for the balance
	public void setBalance(double balance){
		this.balance = balance;
	}

		public double getBalance(){
			return balance;
			}

//getters and setters for the passcode
public void setPasscode(int passcode)
{
	this.passcode= passcode;
}

	public int getPasscode()
	{
		return passcode;
	}

//set the methods
/*
these methods are used to inform the user whether they can withdraw

public boolean withdraw(double amount)
public void deposit(double amount)
public void display()

*/


public double withdraw(double amount)
{
	System.out.println("Please enter passcode to access your account");
	//store user's choice and compare it to the initially set pin
	int pin = userPin.nextInt();

	if(pin == passcode)
	{
				if(amount<=balance)
				{
					balance -= amount;
					System.out.println("Withdraw sucessful. Remaining Balance " + balance);
					System.out.println("Thank you for banking with us");
				}
				else if(amount > balance)
				{
					System.out.println("Insufficient funds in your account. Do you wish for an overdraft? (yes/no)");

					//store user's choice in variable
					String choice = userChoice.nextLine();

					//convert the letter to uppercase
					choice.toUpperCase();

					switch(choice)
					{
						case "YES":
							balance -= amount;
							System.out.println("Thank you for banking with us");
							System.out.println("New balance " + (balance-amount));
							break;

							case "NO":
							System.out.println("Thank you for banking with us, good day");
							break;

							default:
							System.out.println("Invalid choice");
					}
				}
				else
				{
					System.out.println("Please enter an amount");
				}

	}
	else
	{
		System.out.println("Invalid pin, please enter correct pin to access account");
	}

	return amount;

}
//deposit the amount to the bank account
	public void deposit(double amount)
	{
		balance += amount;
		System.out.println("New balance " + balance);
		System.out.println("Thank you for banking with us");
	}


//displays the balance in the account
		public double displayBalance()
		{
			return balance;

		}

//display full bank details
public void bankDetails()
{
	System.out.println("Account ID: " + accountId);
	System.out.println("Account Name: " + accountName);
	System.out.println("Balance: " + balance);
}

//end of code
}