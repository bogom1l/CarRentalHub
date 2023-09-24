package org.carrentalhub.model.user;

import org.carrentalhub.model.car.Car;
import org.carrentalhub.model.part.Part;
import org.carrentalhub.model.user.util.UniqueIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private UniqueIdGenerator idGenerator = new UniqueIdGenerator();
    private List<Car> myCars;
    private List<Car> myFavoriteCars;
    private List<Car> myRentedCars;
    private List<Part> myPurchasedParts;
    private boolean loggedIn;

    public User() {
        myCars = new ArrayList<>();
        myFavoriteCars = new ArrayList<>();
        myRentedCars = new ArrayList<>();
        myPurchasedParts = new ArrayList<>();
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}