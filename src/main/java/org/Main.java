package org;

import org.carrentalhub.ui.ConsoleUI;
import org.carrentalhub.dao.contracts.UserDao;
import org.carrentalhub.dao.UserDaoImpl;
import org.carrentalhub.service.UserManager;

public class Main {
    public static void main(String[] args) {

        ConsoleUI consoleUI = new ConsoleUI();
        UserDao userDao = new UserDaoImpl(consoleUI);
        UserManager userService = new UserManager(userDao, consoleUI);

        while (true) {
            int choice = consoleUI.displayMenuAndGetChoice();
            userService.processUserChoice(choice);
        }

    }
}