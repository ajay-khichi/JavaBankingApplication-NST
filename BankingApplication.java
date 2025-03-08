import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public Account(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankingApplication {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int accountCounter = 1000;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBanking System Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: checkBalance(); break;
                case 5: System.out.println("Exiting the system. Goodbye!"); return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine();  // Consume newline
        String name = scanner.nextLine();
        Account newAccount = new Account(name, accountCounter++);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Your Account Number is: " + newAccount.getAccountNumber());
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.displayAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static Account findAccount(int accNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                return acc;
            }
        }
        return null;
    }
}
