package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
    Book book;
    Library library;
    CheckoutBook checkoutBook;

    @BeforeEach
    public void init(){
        book = mock(Book.class);
        library = mock(Library.class);
        checkoutBook = new CheckoutBook(library);
    }

    @Test
    public void shouldDisplayName() {
        String name = "Checkout Book";
        assertThat(name, is(equalTo(checkoutBook.toString())));
    }

}