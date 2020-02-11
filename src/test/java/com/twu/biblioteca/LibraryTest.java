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
    Book book1;
    ArrayList<Book> books = new ArrayList<>();

    @BeforeEach
    public void init(){
        book1 = new Book("1","1",1);
        books.add(book1);
    }

    @Test
    public void shouldGetABook() {
        Book book = mock(Book.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        Library library = new Library(books);

        assertThat(books, is(equalTo(library.getBooks())));
    }
    @Test
    public void shouldCheckoutABook(){
        Book book2 = new Book("2","2",2);
        books.add(book2);
        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(book2);
        library = new Library(books);

        library.checkout(book1.getTitle());

        assertThat(availableBooks,is(equalTo(library.getBooks())));
    }

}