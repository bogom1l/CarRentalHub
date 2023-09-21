package org.example;

public class Car {
    private String make;
    private String model;
    private int year;
    private double rentPrice;
    private CarCategory category;
    private CarColor color;

    public Car(String make, String model, int year, double rentPrice, CarCategory category, CarColor color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentPrice = rentPrice;
        this.category = category;
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }
}
