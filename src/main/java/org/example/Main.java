package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userManager.registerUser(userDao, scanner);
                    break;
                case 2:
                    userManager.loginUser(userDao, scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }




}