package java.objects.BankModel.EquityBankModel;

/*** Description:Main Bank account that is the parent of all bank accounts in the Bank.
 * Contains methods and fields that will be inherited from subclasses*/
class BankAccount {
    private int id;
    private String owner;
    private double balance, minimumBalance;

    BankAccount() {
    }

    /**
     * Constructor
     *
     * @param id             user id
     * @param owner          bank account owner
     * @param balance        balance in the account
     * @param minimumBalance minimum balance allowed by the bank for the account
     */
    BankAccount(int id, String owner, double balance, double minimumBalance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    /**
     * Withdraw amount from account
     *
     * @param amount amount withdrawn from the account
     */
    public double withdraw(double amount) {
        return this.getBalance() - amount;
    }

    /**
     * Deposit into bank account
     *
     * @param amount Amount to deposit into bank account
     */
    public double deposit(double amount) {
        return this.getBalance() + amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
