package com.twu.biblioteca.core;

import com.twu.biblioteca.interfaces.LibraryItem;

import java.util.Objects;

public class Movie extends LibraryItem {
    private final String title;
    private final Integer year;
    private final String director;
    private final Float movieRating;

    public Movie(String title, Integer year, String director, Float movieRating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    public Movie match(String title) {
        if (this.title.toLowerCase().equals(title))
            return this;
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-30s", title, year, director, movieRating);
    }
}
