package BankModel.EquityBankModel;

/** Description:Charges monthly maintainance fee to the account*/
class CurrentAccount extends BankAccount{
    private double maintainanceFee;

    public CurrentAccount(double maintainanceFee) {
        this.maintainanceFee = maintainanceFee;
    }

    /**Constructor for the current account inheriting from super
     * @param maintainanceFee fee that will be deducted from the current account*/
    public CurrentAccount(int id, String owner, double balance, double minimumBalance, double maintainanceFee) {
        super(id, owner, balance, minimumBalance);
        this.maintainanceFee = maintainanceFee;
    }

    private void deductMonthlyFee(){
        if(this.getBalance() <= this.getMinimumBalance()){
            //display error
            System.out.println("Your funds are low");
        }else{
            this.getBalance() -= this.getMaintainanceFee();
        }
    }

    public double getMaintainanceFee() {return maintainanceFee;}

    public void setMaintainanceFee(double maintainanceFee) {
        this.maintainanceFee = maintainanceFee;
    }
}
