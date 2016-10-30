
Consider Equity Bank’s BankAccount classes as defined in the UML diagram below. Equity Bank also offers
their customers additional account types:
 A CurrentAccount that charges a monthly maintenance fee on the balance
 Savings Account that earns a monthly interest to the balance
BankAccount
-id: int
-owner : String
-balance: double
-minimumbalance: double
+BankAccount(anid:int,anowner:String,
somebalance:double)
+setOwner(diffowner:String)
+getOwner():String
+getBalance():double
+withdraw(amount:double)
+deposit(amount:double):double
SavingsAccount CurrentAccount
-interestRate: double -maintenancefee:double
+SavingsAccount(int anid, String owner, +CurrentAccount(int anid, String owner,
double somebalance,double rate)
+addMonthlyInterest():void
double somebalance,double fee)
+deductMontlyFee():void