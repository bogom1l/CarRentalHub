package org.example;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDaoImpl implements UserDao {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> users;

    public UserDaoImpl() {
        users = readUsersFromJson();
    }

    @Override
    public List<User> readUsersFromJson() {
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

        System.out.println("Registration successful!");
        return true;
    }

    @Override
    public User login(String username, String password) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();

        return userOptional.orElse(null);
    }

    @Override
    public void saveUsersToJson() {
        try {
            objectMapper.writeValue(new File("users.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}