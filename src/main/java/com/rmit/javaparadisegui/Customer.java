package com.rmit.javaparadisegui;

import java.io.Serializable;

public class Customer implements Serializable {

    private int custId;
    private String name;
    static int nextID = 100;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
        custId = nextID++;
    }

    public int getCustId() {
        return custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer ID: " + custId + ", name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return custId == customer.custId && name.equals(customer.name);
    }
    
    @Override
    public int hashCode() {
        return 1;
    }

}
