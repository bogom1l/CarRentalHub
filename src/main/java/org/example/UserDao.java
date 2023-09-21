package org.example;

import java.util.List;

public interface UserDao {
    List<User> readUsersFromJson();
    boolean register(User newUser);
    User login(String username, String password);
    void saveUsersToJson();
}
