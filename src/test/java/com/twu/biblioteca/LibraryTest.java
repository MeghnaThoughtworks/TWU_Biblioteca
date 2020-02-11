package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class LibraryTest {

    @Test
    public void shouldGetABook() {
        Book book = mock(Book.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        Library library = new Library(books);

        assertThat(books, is(equalTo(library.getBooks())));
    }
}