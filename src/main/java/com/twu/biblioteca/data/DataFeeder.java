package com.twu.biblioteca.data;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Movie;
import com.twu.biblioteca.core.User;

import java.util.ArrayList;

public class DataFeeder {

    public static ArrayList<Book> books() {
        Book book1 = new Book("Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Murder on the Orient Express", "Agatha Christie", 1956);
        Book book3 = new Book("IT", "Stephen King", 1986);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }

    public static ArrayList<Movie> movies() {
        String title = "Parasite";
        Integer year = 2020;
        String director = "Bong Joon-Ho";
        Float movieRating = 8.6f;
        Movie movie1 = new Movie(title, year, director, movieRating);
        Movie movie2 = new Movie("1917", 2020, "Sam Mender", 8.5f);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        return movies;
    }

    public static ArrayList<User> users() {
        String libraryNumber = "1234";
        String password = "123";
        User user1 = new User(libraryNumber, password);
        User user2 = new User("123", "12");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        return users;
    }
}
