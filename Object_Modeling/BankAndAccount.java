import java.util.*;

class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getCustomerName() + " has joined " + bankName);
    }

    public void openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account newAccount = new Account(accountNumber, initialBalance, this);
        customer.addAccount(newAccount);
        System.out.println("Account " + accountNumber + " opened for " + customer.getCustomerName() + " at " + bankName);
    }

    public void displayCustomers() {
        System.out.println("\nCustomers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println(" - " + customer.getCustomerName());
            customer.displayAccounts();
        }
    }
}

class Customer {
    private String customerName;
    private String customerID;
    private ArrayList<Account> accounts;

    public Customer(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("\n" + customerName + "'s Accounts:");
        for (Account account : accounts) {
            System.out.println(" - Account " + account.getAccountNumber() + " Balance: $" + account.getBalance());
        }
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println("   * Account " + account.getAccountNumber() + " Balance: $" + account.getBalance());
        }
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAndAccount {
    public static void main(String[] args) {
       
        Bank bank = new Bank("XYZ Bank");

        Customer customer1 = new Customer("Alice", "C101");
        Customer customer2 = new Customer("Bob", "C102");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.openAccount(customer1, "A001", 5000);
        bank.openAccount(customer1, "A002", 10000);
        bank.openAccount(customer2, "A003", 7000);

        bank.displayCustomers();
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
