package com.rmit.week1.Movies;

public class Movie {
  // instance variables
  private String title;
  private String director;
  private int year;
  private int rating;

  public Movie() {
  }

  public Movie(String title) {
    this.title = title;
  }

  public Movie(String title, String director, int year, int rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    if (rating >= 0 && rating <= 5)
      this.rating = rating;
    else
      this.rating = 0;
  }

  // get methods - accessor
  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public int getYear() {
    return year;
  }

  public int getRating() {
    return rating;
  }

  // set methods
  public void setTitle(String title) {
    this.title = title;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setRating(int rating) {
    if (rating >= 0 && rating <= 5)
      this.rating = rating;
    else
      this.rating = 0;
  }

  public String toString() {
    return "Title: " + title + "\nDirector: " + director + "\nYear: " + year + "\nRating: " + rating;
  }

}