/*
Write a Java program that simulates an ATM machine. The program should handle the following exceptions:
InsufficientFundsException: Thrown when a user tries to withdraw an amount greater than their account balance.
InvalidAmountException: Thrown when a user tries to withdraw a negative or zero amount.
The program should have the following functionalities:
Initialise the account balance with a default value.
Provide options for the user to deposit or withdraw funds.
Handle exceptions appropriately and display meaningful error messages to the user.
 */
import java.util.Scanner;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class InvalidAmountException extends Exception{
    public InvalidAmountException(String massage){
        super(massage);
    }
}

class Atm{
    private int balance=300;
    public void deposit(int amount) {
        balance += amount;
        System.out.println("deposited: " + amount);
        System.out.println("Total Amount: "+balance);
    }
    public void withdraw(int amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal :" + amount);
        }


        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds :" + balance);
        }
        balance -= amount;
        System.out.println("Successfully Amount withdrawal:" + amount);
    }

    public int getAccountBalance() {
        return balance;
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm();
        System.out.println("Balance :" + atm.getAccountBalance());



        System.out.println("press 1 for Deposit");
        System.out.println("press 2 for Withdraw");

        System.out.print("Select option: ");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.print("deposit amount of: ");
                int amount = scanner.nextInt();
                atm.deposit(amount);


            } else if (option == 2) {
                System.out.print("withdrawal amount of:");
                int amount = scanner.nextInt();
                try {
                    atm.withdraw(amount);

                } catch (InvalidAmountException | InsufficientFundsException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }


                else {
                System.out.println("Invalid option.");
            }
        }
    }


