package com.pluralsight;

public class Product {
    private int iD;
    private String name;
    private double price;

    public Product(int iD, String name, double price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    public int getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.printf("ID: %d Name: %s Price: %.2f\n", this.iD, this.name, this.price);
    }
}
