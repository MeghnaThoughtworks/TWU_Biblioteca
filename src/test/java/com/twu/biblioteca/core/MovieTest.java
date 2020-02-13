package com.twu.biblioteca.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class MovieTest {
    String title;
    Integer year;
    String director;
    Float movieRating;

    @BeforeEach
    public void init(){
        title = "Parasite";
        year = 2020;
        director = "Bong Joon-Ho";
        movieRating = 8.6f;
    }

    @Test
    public void shouldEquateTwoMoviesTogether(){
        Movie movie1 = new Movie(title,year,director,movieRating);
        Movie movie2 = new Movie(title,year,director,movieRating);

        assertThat(movie1,is(equalTo(movie2)));
        assertThat(movie1.hashCode(),is(equalTo(movie2.hashCode())));
    }
}