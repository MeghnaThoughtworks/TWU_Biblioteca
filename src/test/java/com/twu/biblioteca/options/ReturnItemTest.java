package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.ItemCantReturnException;
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

class ReturnItemTest {
    Book book;
    Catalog<Book> library;
    InputReader inputReader;
    ReturnItem<Book> aReturnItem;
    OutputUI outputUI;
    User user;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        //noinspection unchecked
        library = mock(Catalog.class);
        inputReader = mock(InputReader.class);
        outputUI = mock(OutputUI.class);
        user = new User("123", "12");
        ArrayList<User> users = new ArrayList<>() {{
            add(user);
        }};
        aReturnItem = new ReturnItem<>(library, inputReader, "Return Book", outputUI, users);
    }

    @Test
    public void shouldDisplayName() {
        String name = "Return Book";

        assertThat(name, is(equalTo(aReturnItem.toString())));
    }

    @Test
    public void shouldReturnBook() throws IOException, UserNotFoundException, ItemCantReturnException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        aReturnItem.onSelect();

        verify(library, times(1)).returnItem(inputReader.getTitle());
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException, UserNotFoundException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        aReturnItem.onSelect();

        verify(outputUI, times(1)).display(Message.RETURN_BOOK_SUCCESS);
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException, UserNotFoundException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(inputReader.getUserNumber()).thenReturn("123");
        when(inputReader.getUserPassword()).thenReturn("12");

        aReturnItem.onSelect();

        verify(outputUI, times(1)).display(Message.RETURN_BOOK_UNSUCCESS);
    }
}
