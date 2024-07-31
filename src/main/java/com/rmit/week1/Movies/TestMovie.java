package com.rmit.week1.Movies;

public class TestMovie {
  public static void main(String[] args) {
    Movie m1 = new Movie();
    System.out.println(m1);
    m1.setTitle("Hanna");
    m1.setDirector("Jolly Wrong");
    m1.setYear(2010);
    m1.setRating(5);
    System.out.println(m1);
    // another instance
    Movie m2 = new Movie("War and Peace", "Joe Write", 1999, 3);
    System.out.println(m2);
    // try invalid rating for m1
    m1.setRating(10);
    System.out.println(m1);

  }
}