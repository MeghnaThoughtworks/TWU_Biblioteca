package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.ItemNotFoundException;
import com.twu.biblioteca.core.User;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.OutputUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;


class CheckoutItemTest {
    Book book;
    Catalog<Book> bookCatalog;
    InputReader inputReader;
    CheckoutItem<Book> checkoutItem;
    OutputUI outputUI;
    User user = new User("123", "12");
    ArrayList<User> users = new ArrayList<>() {{
        add(user);
    }};

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        bookCatalog = mock(Catalog.class);
        inputReader = mock(InputReader.class);
        outputUI = mock(OutputUI.class);
        checkoutItem = new CheckoutItem<>(bookCatalog, inputReader, users, "Checkout Book", outputUI);
    }

    @Test
    public void shouldDisplayName() {
        String name = "Checkout Book";

        assertThat(name, is(equalTo(checkoutItem.toString())));
    }

    @Test
    public void shouldCheckoutBook() throws IOException, UserNotFoundException, ItemNotFoundException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        checkoutItem.onSelect();

        verify(bookCatalog, times(1)).checkoutItem(inputReader.getTitle(), user);
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException, UserNotFoundException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        checkoutItem.onSelect();

        verify(outputUI, times(1)).display(Message.CHECKOUT_BOOK_SUCCESS);
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException, UserNotFoundException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        checkoutItem.onSelect();

        verify(outputUI, times(1)).display(Message.CHECKOUT_BOOK_UNSUCCESS);
    }
}