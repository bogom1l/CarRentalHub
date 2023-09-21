package org.example;

import java.util.Scanner;

public class UserService {

    private void registerUser(UserDaoImpl userDaoImpl, Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        User newUser = new User(username, password);
        userDaoImpl.register(newUser);
    }

    private void loginUser(UserDaoImpl userDaoImpl, Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        User user = userDaoImpl.login(username, password);

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("User Profile:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Id: " + user.getId());
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }

}
