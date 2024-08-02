package com.rmit.week3.PersonArray;

public class Student extends Person {
    private int year;
    private String program;

    public Student() {
    }

    public Student(String name, String address, String phone,
            String email) {
        super(name, address, phone, email);
    }

    public Student(String name, String address, String phone,
            String email, String program, int year) {
        super(name, address, phone, email);
        this.program = program;
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProgram: " + program + "\nyear:" + year;
    }
}// class Student
