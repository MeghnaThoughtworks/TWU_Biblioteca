package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class MenuTest {

    @Test
    public void shouldGetMenuOptions() {
        ArrayList<Option> options = new ArrayList<>();
        options.add(new ListBooks(mock(Library.class)));
        Menu menu = new Menu(options);

        assertThat(options, is(CoreMatchers.equalTo(menu.getOptions())));
    }
}