package java.objects.BankModel;

import javax.swing.*;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        JOptionPane joptionPane = new JOptionPane();
        double deposit;
        double withdraw;
        double openBal;
        //introduce user to Bank
        JOptionPane.showMessageDialog(null, "Welcome to LuDynamic Bank \n We got you covered.");
        String name = JOptionPane.showInputDialog(null, "Please enter a name that will be used as your bank account name");
        String bal = JOptionPane.showInputDialog(null, "Please do enter the initial amount you wish to deposit with LuDynamic");

        openBal = Double.parseDouble(bal);
        //create java.objects of the class BankModel.Account
        Account account1 = new Account(openBal, name);

        //display the initial balance to the user

        System.out.printf("Your Initial Balance is : %.2f\n", account1.getBalance());

        //allow user to deposit money into the above accounts
        System.out.println("Do you wish to deposit into your account?(Y/N)");
        String answer = userIn.next();
        answer.toUpperCase();

        if (answer.equals("Y")) {
            String depositAmount = JOptionPane.showInputDialog("Enter the amount to deposit");
            deposit = Double.parseDouble(depositAmount);
            account1.credit(deposit);
        } else {
            System.out.println("Do you wish to withdraw?(Y/N)");
            String option2 = userIn.next();
            option2.toUpperCase();
            if (option2.equals("Y")) {
                String withdrawAmount = JOptionPane.showInputDialog("Enter the amount to Withdraw");
                withdraw = Double.parseDouble(withdrawAmount);
                account1.debit(withdraw);
            }
        }

        //display the new balance
        account1.displayBankDetails();

    }//main method end
//end
}