package org.carrentalhub.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public int displayMenuAndGetChoice() {
        int userChoice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return userChoice;
    }

    public String promptForUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String promptForPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}