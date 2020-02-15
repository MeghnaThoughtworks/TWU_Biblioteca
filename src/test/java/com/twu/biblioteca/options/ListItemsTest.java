package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.OutputUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListItemsTest {
    Catalog<Book> library;
    OutputUI outputUI;
    ListItems<Book> listItems;

    @BeforeEach
    public void init() {
        outputUI = mock(OutputUI.class);
        library = mock(Catalog.class);
        listItems = new ListItems<Book>(library, "List Books", outputUI);
    }

    @Test
    public void shouldInvokeQuit() {
        listItems.onSelect();

        verify(outputUI, times(1)).display(library.toString());

    }

    @Test
    public void shouldDisplayName() {
        String name = "List Books";

        assertThat(name, is(equalTo(listItems.toString())));
    }
}
