package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Library;
import com.twu.biblioteca.options.ListBooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListBooksTest {
    Library library;
    ListBooks listBooks;

    @BeforeEach
    public void init() {
        library = mock(Library.class);
        listBooks = new ListBooks(library);
    }

    @Test
    public void shouldInvokeQuit() {
        assertThat(listBooks.execute(), is(equalTo(library.toString())));
    }

    @Test
    public void shouldDisplayName() {
        String name = "List Books";

        assertThat(name, is(equalTo(listBooks.toString())));
    }
}
