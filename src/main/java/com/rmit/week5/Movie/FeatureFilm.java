package com.rmit.week5.Movie;

public class FeatureFilm extends Movie {
    private String genre;

    public FeatureFilm() {
    }

    public FeatureFilm(String title, String director, int year, double rating, String genre) {
        super(title, director, year, rating);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPurpose() {
        this.purpose = "entertainment";
    }

}