package BankModel.EquityBankModel;

import javax.swing.*;

public class BankTest {
    private static SavingsAccount savingsAccount;
    private static CurrentAccount currentAccount;
    private static final double minBal = 2000;
    private static final double fee = 5;
    private static final double rate = 3;

    public static void main(String[] args){
        JOptionPane.showMessageDialog(null,"Welcome to Equity Bank.");

        String accountType = JOptionPane.showInputDialog(null,"Which type of account would you like?" +
                " \n Savings(S) \n Current(C)");
        String owner = JOptionPane.showInputDialog(null,"Please enter your account name");
        String bal = JOptionPane.showInputDialog(null,"Please enter your initial deposit.");
        double openBal = Double.parseDouble(bal);

        //if savings
        if(accountType.equalsIgnoreCase("S")){
            savingsAccount = new SavingsAccount(1, owner, openBal, minBal, rate);
            savingsAccount.setInterestRate(rate);
            savingsAccount.addMonthlyInterest();
            System.out.println("Current Balance:" + savingsAccount.getBalance());

        }else{
            currentAccount = new CurrentAccount(1,owner,openBal,minBal,fee);
            currentAccount.setMaintainanceFee(fee);
            currentAccount.deductMonthlyFee();
            System.out.println("Current Balance: " + currentAccount.getBalance());
        }
    }
}
