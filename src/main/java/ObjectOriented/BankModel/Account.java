package BankModel;

import javax.swing.*;

public class Account {
    //global or instance variable
    private double balance;
    private JOptionPane joptionPane = new JOptionPane();
    private String userAccountName;

    //constructor will validate the amount in the bank account balance
    public Account(double initialBal, String accountName) {
        if (initialBal > 0.0)
            balance = initialBal;

        userAccountName = accountName;
    }

    //setting the name
    public void setUserAccounName(String accountName) {
        userAccountName = accountName;
    }

    //get the name
    public String getUserAccountName() {
        return userAccountName;
    }

    //add an amount to the balance
    public void credit(double amount) {
        balance = balance + amount;
    }

    //method that withdraws money
    public void debit(double amount) {
        if (amount > balance) {
            String userR = JOptionPane.showInputDialog("You can't withdraw more than what you have, do you wish for an overdraft?(Y/N)");
            if (userR.equals("Y")) {
                balance = balance - amount;
                String message = String.format("Your new balance is: %.2f", balance);
                JOptionPane.showMessageDialog(null, message);
            } else {
                displayBankDetails();
            }
        } else {
            balance = balance - amount;
        }
    }

    //return the final amount in the account
    public double getBalance() {
        return balance;
    }

    public void displayBankDetails() {
        String userAcName = getUserAccountName();
        Double userBankBal = getBalance();
        String message = String.format("Your BankModel.Account details\n BankModel.Account name: %s\n Balance %.2f\n Thank your for banking with LuDynamic", userAcName, userBankBal);
        JOptionPane.showMessageDialog(null, message);
    }
//end
}