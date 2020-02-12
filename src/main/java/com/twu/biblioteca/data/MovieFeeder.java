package com.twu.biblioteca.data;

import com.twu.biblioteca.core.Movie;

import java.util.ArrayList;

public class MovieFeeder {

    public static ArrayList<Movie> movies() {
        String title = "Parasite";
        Integer year = 2020;
        String director = "Bong Joon-Ho";
        Float movieRating = 8.6f;
        Movie movie1 = new Movie(title,year,director,movieRating);
        Movie movie2 = new Movie("1917",2020,"Sam Mender",8.5f);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        return movies;
    }
}
