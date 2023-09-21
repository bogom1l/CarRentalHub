package org.carrentalhub.dao.contracts;

import org.carrentalhub.model.user.User;

public interface UserDao {
    boolean register(User newUser);

    User login(String username, String password);
}