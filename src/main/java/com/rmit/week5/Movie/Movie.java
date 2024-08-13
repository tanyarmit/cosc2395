package com.rmit.week5.Movie;

public abstract class Movie implements Comparable<Movie> {
    // title, director, year, and rating
    protected String title;
    protected String director;
    protected int year;
    protected double rating;
    protected String purpose;

    public Movie() {
    }

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    public abstract void setPurpose();

    @Override
    public int compareTo(Movie o) {
        return Double.compare(this.rating, o.rating);
    }
}
