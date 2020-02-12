package com.twu.biblioteca.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryTest {
    Library library;
    Book book;
    Book book1;

    @BeforeEach
    public void init() {
        book = new Book("1","1",1);
        book1 = new Book("2","2",2);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        library = new Library(books);
    }

    @Test
    public void shouldCheckoutABook() {
        library.checkout("1");
        String expectedResult = "(1) " + book1.toString() + "\n";

        assertThat(expectedResult, is(equalTo(library.toString())));
    }

    @Test
    public void shouldReturnABook() {
        library.checkout("1");
        library.checkout("2");
        library.returnBook("1");
        String expectedResult = "(1) " + book.toString() + "\n";

        assertThat(expectedResult, is(equalTo(library.toString())));
    }
}