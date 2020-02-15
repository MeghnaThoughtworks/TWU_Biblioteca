package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListItemsTest {
    Catalog<Book> library;
    ListItems<Book> listItems;

    @BeforeEach
    public void init() {
        library = mock(Catalog.class);
        listItems = new ListItems<>(library);
    }

    @Test
    public void shouldInvokeQuit() {
        assertThat(listItems.onSelect(), is(equalTo(library.toString())));
    }

    @Test
    public void shouldDisplayName() {
        String name = "List";

        assertThat(name, is(equalTo(listItems.toString())));
    }
}
