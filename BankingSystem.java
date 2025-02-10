import java.util.*;

abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber(){ return accountNumber; }
    public String getHolderName(){ return holderName; }
    public double getBalance(){ return balance; }

    public void setBalance(double balance){ this.balance = balance; }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("Amount "+amount+" deposited successfully by "+holderName+" in account number "+accountNumber);
        System.out.println("Current balance is "+balance);
    }
    public void withdraw(double amount){
        if(amount < 0 || amount > balance){
            System.out.println("Invalid amount");
            return;
        }
        balance -= amount;
        System.out.println("Amount "+amount+" withdrawn successfully by "+holderName+" in account number "+accountNumber);
        System.out.println("Current balance is "+balance);
    }

    abstract double calculateInterest();

    public void display(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Lonable{
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingAccount extends BankAccount implements Lonable{
    private double interestRate;

    public SavingAccount(String accountNumber, String holderName, double balance, double interestRate){
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        return getBalance() * interestRate / 100;
    }

    public void applyForLoan(double amount){
        if(calculateLoanEligibility()){
            System.out.println("Loan of amount "+amount+" is approved for "+getHolderName());
            setBalance(getBalance() + amount);
            System.out.println("Current balance is "+getBalance());
        }
        else{
            System.out.println("Loan of amount "+amount+" is not approved for "+getHolderName());
        }
    }

    public boolean calculateLoanEligibility(){
        if(getBalance() * 0.4 > 0){
            return true;
        }
        return false;
    }
} 

class CurrentAccount extends BankAccount implements Lonable{
    private double interestRate = 0;

    public CurrentAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest(){
        return getBalance() * interestRate / 100;
    }

    public void applyForLoan(double amount){
        if(calculateLoanEligibility()){
            System.out.println("Loan of amount "+amount+" is approved for "+getHolderName());
            setBalance(getBalance() + amount);
            System.out.println("Current balance is "+getBalance());
        }
        else{
            System.out.println("Loan of amount "+amount+" is not approved for "+getHolderName());
        }
    }

    public boolean calculateLoanEligibility(){
        if(getBalance() * 0.4 > 0){
            return true;
        }
        return false;
    }
}

class BankingSystem{
    public static void main(String[] args){
        BankAccount savingAccount = new SavingAccount("123456789", "Aryan Tripathi", 10000, 4);
        savingAccount.display();
        savingAccount.deposit(5000);
        savingAccount.withdraw(2000);
        System.out.println("Interest: "+savingAccount.calculateInterest());
        ((Lonable)savingAccount).applyForLoan(5000);

        System.out.println("\n----------------------------------------------\n");

        BankAccount currentAccount = new CurrentAccount("987654321", "Priyansu Kashyap", 20000);
        currentAccount.display();
        currentAccount.deposit(10000);
        currentAccount.withdraw(5000);
        System.out.println("Interest: "+currentAccount.calculateInterest());
        ((Lonable)currentAccount).applyForLoan(5000);
    }
}