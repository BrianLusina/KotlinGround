package BankModel.EquityBankModel;

/**
 * Description:
 */
public class BankAccount {
    private int id;
    private String ownwer;
    private double balance;
    private double minimumBalance;

    public BankAccount(){}

    /**Constructor
     * @param id user id
     * @param ownwer bank account owner
     * @param balance balance in the account
     * @param minimumBalance minimum balance allowed by the bank for the account*/
    public BankAccount(int id, String ownwer, double balance, double minimumBalance) {
        this.id = id;
        this.ownwer = ownwer;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    /**Withdraw amount from account
     * @param amount amount withdrawn from the account*/
    public double withdraw(double amount){
        return this.getBalance() - amount;
    }

    /**Deposit into bank account
     * @param amount Amount to deposit into bank account*/
    public double deposit(double amount){
        return this.getBalance() + amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnwer() {
        return ownwer;
    }

    public void setOwnwer(String ownwer) {
        this.ownwer = ownwer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
