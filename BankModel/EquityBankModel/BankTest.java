package BankModel.EquityBankModel;

public class BankTest {
    public static void main(String[] args){
        SavingsAccount johnDoeSavings = new SavingsAccount(1, "John Doe", 10000, 2000, 5);

        System.out.println(johnDoeSavings.getBalance());
        johnDoeSavings.addMonthlyInterest();
        System.out.println(johnDoeSavings.getBalance());
    }
}
