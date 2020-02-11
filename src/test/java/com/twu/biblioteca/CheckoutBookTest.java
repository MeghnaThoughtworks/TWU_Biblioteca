package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
    Library library = mock(Library.class);
    CheckoutBook checkoutBook = new CheckoutBook(library);

    @Test
    public void shouldDisplayName() {
        String name = "Checkout Book";
        assertThat(name, is(equalTo(checkoutBook.toString())));
    }

}