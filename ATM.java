import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userId = "123456"; // Example user ID
        String pin = "1234"; // Example PIN
        int balance = 1000;
        String[] transactionHistory = new String[10];
        int numTransactions = 0;
        boolean isLoggedIn = false;

        System.out.println("Welcome to the ATM!");

        while (true) {
            if (!isLoggedIn) {
                System.out.print("Enter your user ID: ");
                String enteredUserId = scanner.nextLine();

                System.out.print("Enter your PIN: ");
                String enteredPin = scanner.nextLine();

                if (enteredUserId.equals(userId) && enteredPin.equals(pin)) {
                    isLoggedIn = true;
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid user ID or PIN. Please try again.");
                }
            } else {
                System.out.println("What would you like to do?");
                System.out.println("1. Check transaction history");
                System.out.println("2. Withdraw money");
                System.out.println("3. Deposit money");
                System.out.println("4. Transfer money");
                System.out.println("5. Quit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("Transaction history:");

                        for (int i = 0; i < numTransactions; i++) {
                            System.out.println(transactionHistory[i]);
                        }

                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();

                        if (withdrawAmount > balance) {
                            System.out.println("Insufficient funds.");
                        } else {
                            balance -= withdrawAmount;
                            String transaction = "Withdrawal of $" + withdrawAmount;
                            transactionHistory[numTransactions] = transaction;
                            numTransactions++;
                            System.out.println("Withdrawal successful.");
                        }

                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = scanner.nextInt();

                        balance += depositAmount;
                        String transaction = "Deposit of $" + depositAmount;
                        transactionHistory[numTransactions] = transaction;
                        numTransactions++;
                        System.out.println("Deposit successful.");

                        break;
                    case 4:
                        System.out.print("Enter recipient's user ID: ");
                        String recipientUserId = scanner.nextLine();

                        System.out.print("Enter amount to transfer: ");
                        int transferAmount = scanner.nextInt();

                        if (transferAmount > balance) {
                            System.out.println("Insufficient funds.");
                        } else {
                            balance -= transferAmount;
                            String transaction1 = "Transfer of $" + transferAmount + " to user ID " + recipientUserId;
                            String transaction2 = "Received transfer of $" + transferAmount + " from user ID " + userId;
                            transactionHistory[numTransactions] = transaction1;
                            numTransactions++;
                            transactionHistory[numTransactions] = transaction2;
                            numTransactions++;
                            System.out.println("Transfer successful.");
                        }

                        scanner.nextLine(); // Consume newline character

                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM!");
                        scanner.close();
                        System.exit(0);

                        break;
                    default:
                        System.out.println("quit");
                }
            }
        }
    }
}
