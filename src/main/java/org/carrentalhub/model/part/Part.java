package org.carrentalhub.model.part;

public class Part {
    private String name;
    private PartCategory category;
    private String Description;
    private double price;

    public Part(String name, PartCategory category, String description, double price) {
        this.name = name;
        this.category = category;
        Description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartCategory getCategory() {
        return category;
    }

    public void setCategory(PartCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
