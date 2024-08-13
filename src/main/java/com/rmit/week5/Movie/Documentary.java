package com.rmit.week5.Movie;

import java.util.Scanner;

public class Documentary extends Movie {
    private String subject;

    public Documentary() {
    }
    
    public Documentary(String title, String director, int year, double rating, String subject) {
        super(title, director, year, rating);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPurpose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the purpose of the documentary such as 'history', 'current news', etc.: ");
        this.purpose = scanner.nextLine();
    }
}