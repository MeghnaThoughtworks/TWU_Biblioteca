package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ListTest {
    Catalog library;
    List list;

    @BeforeEach
    public void init() {
        library = mock(Catalog.class);
        list = new List(library);
    }

    @Test
    public void shouldInvokeQuit() {
        assertThat(list.onSelect(), is(equalTo(library.toString())));
    }

    @Test
    public void shouldDisplayName() {
        String name = "List Books";

        assertThat(name, is(equalTo(list.toString())));
    }
}
