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

class ReturnItemTest {
    Book book;
    Catalog<Book> library;
    InputReader inputReader;
    ReturnItem<Book> aReturnItem;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        //noinspection unchecked
        library = mock(Catalog.class);
        inputReader = mock(InputReader.class);
        aReturnItem = new ReturnItem<>(library, inputReader, "Return Book");
    }

    @Test
    public void shouldDisplayName(){
        String name = "Return";

        assertThat(name, is(equalTo(aReturnItem.toString())));
    }

    @Test
    public void shouldReturnBook() throws IOException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getTitle())).thenReturn(true);

        aReturnItem.onSelect();

        verify(library,times(1)).returnItem(inputReader.getTitle());
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getTitle())).thenReturn(true);

        assertThat(aReturnItem.onSelect(), is(equalTo(Message.RETURN_BOOK_SUCCESS)));
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException {
        when(inputReader.getTitle()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getTitle())).thenReturn(false);

        assertThat(aReturnItem.onSelect(), is(equalTo(Message.RETURN_BOOK_UNSUCCESS)));
    }
}
