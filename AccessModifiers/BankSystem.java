class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest Applied: $" + interest);
    }

    public void displaySavingsDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", "Alice Johnson", 5000);
        account1.deposit(1000);
        account1.withdraw(2000);
        account1.displayAccountDetails();

        System.out.println();

        SavingsAccount savings1 = new SavingsAccount("789101", "Bob Smith", 3000, 5);
        savings1.applyInterest();
        savings1.displaySavingsDetails();
        savings1.displayAccountDetails();
    }
}
