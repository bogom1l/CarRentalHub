package org.example;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public int displayMenuAndGetChoice() {
        System.out.println("Choose an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int userChoice = scanner.nextInt();
        scanner.nextLine();

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