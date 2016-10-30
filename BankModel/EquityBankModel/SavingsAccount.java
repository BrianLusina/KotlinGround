package BankModel.EquityBankModel;

/*** Description: Account that earns monthly interest to the balance*/
class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount() {}

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    /**Constructor inheriting from {@link BankAccount} constructor
     * @param interestRate Interest rate this account earns*/
    public SavingsAccount(int id, String owner, double balance, double minimumBalance, double interestRate) {
        super(id, owner, balance, minimumBalance);
        this.interestRate = interestRate;
    }

    /**Void method to add interest to the balance of this account
     * Assuming interest rate has already been calculated*/
    public void addMonthlyInterest(){
        double newBalance = this.getBalance() * this.getInterestRate();
        //set the new balance
        this.setBalance(newBalance);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = 1 + (interestRate/100);
    }
}
