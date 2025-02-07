class BankAccount{
    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountType(){
        System.out.println("This is a basic Account.");
    }
}
class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountNumber, int balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType(){
        System.out.println("This is a saving account.");
    }

}
class CheckingAccount extends BankAccount{
    private int withdrawlLimit;

    public CheckingAccount(String accountNumber, int balance, int withdrawlLimit){
        super(accountNumber, balance);
        this.withdrawlLimit = withdrawlLimit;
    }

    public void displayAccountType(){
        System.out.println("This is a checking account.");
    }
}
class FixedDepositAccount extends BankAccount{
    private int fixedDepositPeriod;

    public FixedDepositAccount(String accountNumber, int balance, int fixedDepositPeriod){
        super(accountNumber, balance);
        this.fixedDepositPeriod = fixedDepositPeriod;
    }

    public void displayAccountType(){
        System.out.println("This is a fixed deposit account.");
    }
}

public class BankingSystem{
    public static void main(String args[]){
        BankAccount savingAccount = new SavingsAccount("1234", 1000, 0.05);
        savingAccount.displayAccountType();

        BankAccount checkingAccount = new CheckingAccount("5678", 2000, 100);
        checkingAccount.displayAccountType();
        
        BankAccount fixedDepositAccount = new FixedDepositAccount("91011", 3000, 5);
        fixedDepositAccount.displayAccountType();
    }
}