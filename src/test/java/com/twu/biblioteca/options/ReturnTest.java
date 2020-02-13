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

class ReturnTest {
    Book book;
    Catalog library;
    InputReader inputReader;
    Return aReturn;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        library = mock(Catalog.class);
        inputReader = mock(InputReader.class);
        aReturn = new Return(library, inputReader);
    }

    @Test
    public void shouldDisplayName(){
        String name = "Return Book";
        assertThat(name, is(equalTo(aReturn.toString())));
    }

    @Test
    public void shouldReturnBook() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getInput())).thenReturn(true);

        aReturn.onSelect();

        verify(library,times(1)).returnItem(inputReader.getInput());
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getInput())).thenReturn(true);

        assertThat(aReturn.onSelect(), is(equalTo(Message.RETURN_BOOK_SUCCESS)));
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.returnItemStatus(inputReader.getInput())).thenReturn(false);

        assertThat(aReturn.onSelect(), is(equalTo(Message.RETURN_BOOK_UNSUCCESS)));
    }
}
