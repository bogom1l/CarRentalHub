package org.carrentalhub.service;

import org.carrentalhub.model.user.User;
import org.carrentalhub.dao.contracts.UserDao;
import org.carrentalhub.ui.ConsoleUI;

public class UserManager {
    private UserDao userDao;
    private ConsoleUI consoleUI;

    public UserManager(UserDao userDao, ConsoleUI consoleUI) {
        this.userDao = userDao;
        this.consoleUI = consoleUI;
    }

    public void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                exit();
            default:
                consoleUI.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }

    private void registerUser() {
        String username = consoleUI.promptForUsername();
        String password = consoleUI.promptForPassword();

        User newUser = new User(username, password);

        if (userDao.register(newUser)) {
            consoleUI.displayMessage("Registration successful! Please log in to continue.");
        } else {
            consoleUI.displayMessage("Registration failed.");
        }
    }

    private void loginUser() {
        String username = consoleUI.promptForUsername();
        String password = consoleUI.promptForPassword();

        User user = userDao.login(username, password);

        if (user != null) {
            consoleUI.displayMessage("Login successful! Welcome, " + user.getUsername() + ".");
            user.setLoggedIn(true);
        } else {
            consoleUI.displayMessage("Login failed. Please check your credentials.");
        }
    }

    public void logoutUser(User user) {
        user.setLoggedIn(false);
    }

    private void exit() {
        consoleUI.displayMessage("Program successfully ended.");
        System.exit(0);
    }

    //-----------------------------------------------------------------

    public void processLoggedInUserChoice(int choice) {
        switch (choice) {
            case 1:
                logoutUser();
                break;
            case 4:
                exit();
            default:
                consoleUI.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }
}