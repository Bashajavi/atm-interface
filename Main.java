import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addAccount(new Account(1234, 5678, 1000.0));
        atm.addAccount(new Account(2345, 6789, 2000.0));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        Account userAccount = atm.authenticate(userId, pin);

        if (userAccount != null) {
            System.out.println("Authentication successful!");
            boolean quit = false;

            while (!quit) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        userAccount.printTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient user ID: ");
                        int recipientUserId = scanner.nextInt();
                        Account recipientAccount = atm.authenticate(recipientUserId, pin); // Simulate recipient PIN check for simplicity
                        if (recipientAccount != null && recipientAccount != userAccount) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            userAccount.transfer(recipientAccount, transferAmount);
                        } else {
                            System.out.println("Invalid recipient user ID or same user account.");
                        }
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again.");
        }

        scanner.close();
    }
}
