package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

class MenuTest {
    @Test
    public void shouldGetOption(){
        Option option = mock(Option.class);
        Menu menu = new Menu(option);

        assertThat(option,is(equalTo(menu.getOption())));
    }

}