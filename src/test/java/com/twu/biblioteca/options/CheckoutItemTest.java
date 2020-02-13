package com.twu.biblioteca.options;

import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CheckoutItemTest {
    Book book;
    Catalog<Book> library;
    InputReader inputReader;
    CheckoutItem<Book> checkoutItem;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        library = mock(Catalog.class);
        inputReader = mock(InputReader.class);
        checkoutItem = new CheckoutItem<>(library, inputReader);
    }

    @Test
    public void shouldDisplayName() {
        String name = "Checkout Book";
        assertThat(name, is(equalTo(checkoutItem.toString())));
    }

    @Test
    public void shouldCheckoutBook() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");

        checkoutItem.onSelect();

        verify(library, times(1)).checkoutItem(inputReader.getInput());
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.checkedItemStatus(inputReader.getInput())).thenReturn(true);

        assertThat(checkoutItem.onSelect(), is(equalTo(Message.CHECKOUT_BOOK_SUCCESS)));
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.checkedItemStatus(inputReader.getInput())).thenReturn(false);

        assertThat(checkoutItem.onSelect(), is(equalTo(Message.CHECKOUT_BOOK_UNSUCCESS)));
    }
}