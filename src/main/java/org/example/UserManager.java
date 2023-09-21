package org.example;

import java.util.Scanner;

public class UserManager {

    public void registerUser(UserDao userDao, Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        User newUser = new User(username, password);
        if (userDao.register(newUser)) {
            System.out.println("Registration successful! Please log in with your account to continue.");
        } else {
            System.out.println("Registration failed.");
        }
    }

    public void loginUser(UserDao userDao, Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        User user = userDao.login(username, password);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getUsername() + ".");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}