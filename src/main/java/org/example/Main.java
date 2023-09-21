package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsoleUI consoleUI = new ConsoleUI();
        UserDao userDao = new UserDaoImpl();
        UserManager userService = new UserManager(userDao, consoleUI);

        while (true) {
            int choice = consoleUI.displayMenuAndGetChoice();
            userService.processUserChoice(choice);
        }

//        while (true) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    userManager.registerUser(userDao, scanner);
//                    break;
//                case 2:
//                    userManager.loginUser(userDao, scanner);
//                    break;
//                case 3:
//                    System.out.println("Program successfully ended.");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }

    }
}