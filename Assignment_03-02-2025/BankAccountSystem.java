class BankAccount {
    private static String bankName = "State Bank Of India";
    private static int totalAccounts = 0;
    
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: $" + balance);
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1, "krishna", 5000);
        BankAccount acc2 = new BankAccount(2, "shlok", 7000);
        
        acc1.displayAccountDetails();
        System.out.println();
        acc2.displayAccountDetails();
        
        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
