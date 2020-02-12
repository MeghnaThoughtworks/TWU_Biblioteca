package com.twu.biblioteca.options;

import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ReturnBookTest {
    Book book;
    Library library;
    InputReader inputReader;
    ReturnBook returnBook;

    @BeforeEach
    public void init() {
        book = mock(Book.class);
        library = mock(Library.class);
        inputReader = mock(InputReader.class);
        returnBook = new ReturnBook(library, inputReader);
    }

    @Test
    public void shouldDisplayName(){
        String name = "Return Book";
        assertThat(name, is(equalTo(returnBook.toString())));
    }

    @Test
    public void shouldReturnBook() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.findBookInAvailable(inputReader.getInput())).thenReturn(book);
        when(library.returnedBookStatus(book)).thenReturn(true);

        returnBook.execute();

        verify(library,times(1)).returnBook(book);
    }

    @Test
    public void shouldReturnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.findBookInAvailable(inputReader.getInput())).thenReturn(book);
        when(library.returnedBookStatus(book)).thenReturn(true);

        assertThat(returnBook.execute(), is(equalTo(Message.RETURN_BOOK_SUCCESS)));
    }

    @Test
    public void shouldReturnUnSuccessMessage() throws IOException {
        when(inputReader.getInput()).thenReturn("IT");
        when(library.findBookInAvailable(inputReader.getInput())).thenReturn(book);
        when(library.returnedBookStatus(book)).thenReturn(false);

        assertThat(returnBook.execute(), is(equalTo(Message.RETURN_BOOK_UNSUCCESS)));
    }
}
