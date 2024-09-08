package com.rmit.week7;

import java.io.Serializable;

public class Item implements Serializable {
    /*
     * 1. Create a class Item with two instance variables: String item and double
     * price.
     * This class must implement Serializable interface as we are going to write the
     * objects into a file.
     */
    private String item;
    private double price;

    public Item() {
    }

    public Item(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [item=" + item + ", price=" + price + "]";
    }

}
