public class BankAccountTest
{
	public static void main(String[] args)
{
	//create a new instance of BankAccount
	BankAccount bnk = new BankAccount();


	//set the account id, accunt name and balance
	bnk.setAccountId(202);
	bnk.setAccountName("My Account");
	bnk.setBalance(50000.20);
	bnk.setPasscode(555);

//displays the full bank details as requested by user
bnk.bankDetails();

System.out.println("============================================================================");


//deposit some amount in the bank
	bnk.deposit(50000);

System.out.println("============================================================================");

	bnk.withdraw(500000);


//end of code
}
}