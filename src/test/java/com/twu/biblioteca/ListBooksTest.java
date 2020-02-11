package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListBooksTest {
    ListBooks listBooks = new ListBooks();

    @Test
    public void shouldInvokeQuit() {
        listBooks.execute();

        BibliotecaUI bibliotecaUI = mock(BibliotecaUI.class);
        verify(bibliotecaUI, times(1)).printBooks();
    }

    @Test
    public void shouldDisplayName() {
        String name = "List Books";

        assertThat(name, is(equalTo(listBooks.toString())));
    }

}