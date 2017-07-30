package com.javapp.objects.BankModel.EquityBankModel;

/**
 * Description:Charges monthly maintainance fee to the account
 */
class CurrentAccount extends BankAccount {

  private double maintainanceFee;

  public CurrentAccount() {
  }

  public CurrentAccount(double maintainanceFee) {
    this.maintainanceFee = maintainanceFee;
  }

  /**
   * Constructor for the current account inheriting from super
   *
   * @param maintainanceFee fee that will be deducted from the current account
   */
  public CurrentAccount(int id, String owner, double balance, double minimumBalance,
      double maintainanceFee) {
    super(id, owner, balance, minimumBalance);
    this.maintainanceFee = maintainanceFee;
  }

  /**
   * Deducts the monthly fee from the current account
   */
  public void deductMonthlyFee() {
    double newBalance;
    //if current balance is less that minimum balance display error
    if (this.getBalance() <= this.getMinimumBalance()) {
      System.out.println("Your funds are low");
    } else {
      newBalance = this.getBalance() - this.getMaintainanceFee();
      this.setBalance(newBalance);
    }
  }

  public double getMaintainanceFee() {
    return maintainanceFee;
  }

  public void setMaintainanceFee(double maintainanceFee) {
    this.maintainanceFee = maintainanceFee;
  }
}
