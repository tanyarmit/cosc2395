package com.rmit.week5.Movie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Documentary("The Social Dilemma", "Jeff Orlowski", 2020, 7.7, "social media"));
        movies.add(new FeatureFilm("The Shawshank Redemption", "Frank Darabont", 1994, 9.3, "drama"));
        Movie movie = new FeatureFilm("The Dark Knight", "Christopher Nolan", 2008, 9.0, "action");
        movies.add(movie);
        movies.add(new Documentary("Blackfish", "Gabriela Cowperthwaite", 2013, 8.1, "nature"));
        movies.add(new Documentary("The Cove", "Louie Psihoyos", 2009, 8.4, "environment"));
        movies.add(new Documentary("Citizenfour", "Laura Poitras", 2014, 8.0, "politics"));

        movies.add(new FeatureFilm("Inception", "Christopher Nolan", 2010, 8.8, "sci-fi"));
        movies.add(new FeatureFilm("Pulp Fiction", "Quentin Tarantino", 1994, 8.9, "crime"));

        movies.sort(null);
        for (Movie m : movies) {
            System.out.println(m);
        }
        System.out.println("The best movie is " + movies.get(movies.size()-1).getTitle());
    }
}
