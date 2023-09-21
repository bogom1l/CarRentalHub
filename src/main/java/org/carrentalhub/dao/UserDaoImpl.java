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

public class UserDaoImpl implements UserDao {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> users;

    public UserDaoImpl() {
        users = readUsersFromJson();
    }

    private List<User> readUsersFromJson() {
        try {
            File file = new File("users.json");
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
            System.out.println("Username already taken. Please choose another one.");
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
            objectMapper.writeValue(new File("users.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}