package com.rmit.week3.PersonArray;

public class Person {
    protected String name;
    protected String address;
    protected String phone;
    protected String email;

    public Person() {
    }

    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + "\n" + address + ", " + phone + "\nemail: " + email;
    }

}
