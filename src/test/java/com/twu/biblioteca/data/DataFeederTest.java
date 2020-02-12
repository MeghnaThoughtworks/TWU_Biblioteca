package com.twu.biblioteca.data;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class DataFeederTest {
    String title = "Parasite";
    Integer year = 2020;
    String director = "Bong Joon-Ho";
    Float movieRating = 8.6f;

    @Test
    public void shouldReturnListOfBooks(){
        Book book1 = new Book("Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Murder on the Orient Express", "Agatha Christie", 1956);
        Book book3 = new Book("IT", "Stephen King", 1986);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        assertThat(books,is(equalTo(DataFeeder.books())));
    }

    @Test
    public void shouldReturnListOfMovies(){
        Movie movie1 = new Movie(title,year,director,movieRating);
        Movie movie2 = new Movie("1917",2020,"Sam Mender",8.5f);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        assertThat(movies,is(equalTo(DataFeeder.movies())));
    }
}

