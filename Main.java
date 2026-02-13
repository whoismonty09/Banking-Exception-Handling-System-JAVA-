import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance = 5000;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        System.out.println("Banking Exception Handling System developed by Monty");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");

        int choice = sc.nextInt();

        try {
            if (choice == 1) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                account.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                account.withdraw(amt);
            } else if (choice == 3) {
                System.out.println("Balance: " + account.getBalance());
            } else {
                System.out.println("Invalid choice");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
