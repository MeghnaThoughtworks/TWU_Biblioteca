package com.twu.biblioteca.core;

import com.twu.biblioteca.exceptions.ItemCantReturnException;
import com.twu.biblioteca.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class CatalogTest {
    Catalog<Book> bookCatalog;
    Book book;
    Book book1;
    User user;

    @BeforeEach
    public void init() {
        book = new Book("1", "1", 1);
        book1 = new Book("2", "2", 2);
        user = mock(User.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        bookCatalog = new Catalog<>(books);
    }

    @Test
    public void shouldCheckoutABook() throws ItemNotFoundException {
        bookCatalog.checkoutItem("1", user);
        String expectedResult = book1.toString() + "\n";

        assertThat(expectedResult, is(equalTo(bookCatalog.toString())));
    }

    @Test
    public void shouldReturnABook() throws ItemCantReturnException, ItemNotFoundException {
        bookCatalog.checkoutItem("1", user);
        bookCatalog.checkoutItem("2", user);
        bookCatalog.returnItem("1");
        String expectedResult = book.toString() + "\n";

        assertThat(expectedResult, is(equalTo(bookCatalog.toString())));
    }

}
