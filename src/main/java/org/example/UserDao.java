package org.example;

public interface UserDao {
    boolean register(User newUser);

    User login(String username, String password);
}