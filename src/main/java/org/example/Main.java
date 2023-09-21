package org.example;

public class Main {
    public static void main(String[] args) {

        ConsoleUI consoleUI = new ConsoleUI();
        UserDao userDao = new UserDaoImpl();
        UserManager userService = new UserManager(userDao, consoleUI);

        while (true) {
            int choice = consoleUI.displayMenuAndGetChoice();
            userService.processUserChoice(choice);
        }

    }
}