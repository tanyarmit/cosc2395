package com.rmit.week10;

public class Student {
    private int id;
    private String name;
    private static int counter = 0;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        counter++;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Override toString method for display
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
