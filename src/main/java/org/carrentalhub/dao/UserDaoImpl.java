package org.carrentalhub.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.carrentalhub.dao.contracts.UserDao;
import org.carrentalhub.model.user.User;
import org.carrentalhub.ui.ConsoleUI;

public class UserDaoImpl implements UserDao {
    private static final String filePath = "users.json";

    private ConsoleUI consoleUI;
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> users;

    public UserDaoImpl(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.users = readUsersFromJson();
    }

    private List<User> readUsersFromJson() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean register(User newUser) {
        if (users.stream().anyMatch(u -> u.getUsername().equals(newUser.getUsername()))) {
            consoleUI.displayMessage("Username already taken. Please choose another one.");
            return false;
        }

        users.add(newUser);
        saveUsersToJson();

        return true;
    }

    @Override
    public User login(String username, String password) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();

        return userOptional.orElse(null);
    }

    private void saveUsersToJson() {
        try {
            objectMapper.writeValue(new File(filePath), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}