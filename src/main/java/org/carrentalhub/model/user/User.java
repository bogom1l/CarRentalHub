package org.carrentalhub.model.user;

import org.carrentalhub.model.user.util.UniqueIdGenerator;

public class User {
    private int id;
    private String username;
    private String password;
    private UniqueIdGenerator idGenerator = new UniqueIdGenerator();

    public User() {
    }

    public User(String username, String password) {
        this.id = idGenerator.generateId();
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}