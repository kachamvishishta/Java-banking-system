import java.util.Scanner;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String name, int accNumber) {
        accountHolder = name;
        accountNumber = accNumber;
        balance = 0.0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }

    void accountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user = null;

        System.out.println("---- Welcome to Java Bank ----");
        System.out.print("Enter your name to create an account: ");
        String name = sc.nextLine();

        int accNum = (int)(Math.random() * 9000) + 1000;
        user = new BankAccount(name, accNum);

        System.out.println("Account created successfully!");
        user.accountDetails();

        int choice;
        do {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = sc.nextDouble();
                    user.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = sc.nextDouble();
                    user.withdraw(withdrawAmt);
                    break;
                case 3:
                    user.checkBalance();
                    break;
                case 4:
                    user.accountDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using Java Bank!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
