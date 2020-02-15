package com.twu.biblioteca.interfaces;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.core.Menu;
import com.twu.biblioteca.options.ListItems;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class MenuTest {

    @Test
    public void shouldGetMenuOptions() {
        ArrayList<Option> options = new ArrayList<>();
        options.add(new ListItems<Book>(mock(Catalog.class)));
        Menu menu = new Menu(options);

        assertThat(options, is(CoreMatchers.equalTo(menu.getOptions())));
    }
}