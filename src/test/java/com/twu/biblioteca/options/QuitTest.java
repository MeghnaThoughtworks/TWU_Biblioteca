package com.twu.biblioteca.options;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class QuitTest {
    Quit quit = new Quit();

    @Test
    public void shouldInvokeQuit() {
        quit.onSelect();

        verify(quit, times(1)).quit();
    }

    @Test
    public void shouldDisplayName() {
        String name = "Quit";
        assertThat(name, is(equalTo(quit.toString())));
    }
}