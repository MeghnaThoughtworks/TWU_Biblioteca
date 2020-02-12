package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class LibraryTest {
    Library library;
    Book book;
    Book book1;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        book1 = mock(Book.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        library = new Library(books);
    }

    @Test
    public void shouldCheckoutABook() {
        library.checkout(book);
        String expectedResult = "(1) "+book1.toString()+"\n";

        assertThat(expectedResult,is(equalTo(library.toString())));
    }


}