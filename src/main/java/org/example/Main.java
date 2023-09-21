package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);

        UniqueIdGenerator idGenerator = new UniqueIdGenerator();

        // Generate and print some unique IDs
        for (int i = 0; i < 5; i++) {
            int uniqueId = idGenerator.generateId();
            System.out.println("Generated Unique ID: " + uniqueId);
        }

//
//        while (true) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    registerUser(userManager, scanner);
//                    break;
//                case 2:
//                    loginUser(userManager, scanner);
//                    break;
//                case 3:
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }
    }




}