package com.twu.biblioteca.options;

import com.twu.biblioteca.core.LibraryObject;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;

import java.io.IOException;

public class Checkout<T extends LibraryObject> implements Option {
    private final Catalog<T> catalog;
    private final InputReader inputReader;

    public Checkout(Catalog<T> catalog, InputReader inputReader) {
        this.catalog = catalog;
        this.inputReader = inputReader;
    }

    @Override
    public String onSelect() throws IOException {
        String title = inputReader.getInput();
        catalog.checkoutItem(title);
        if (catalog.checkedItemStatus(title)) {
            return Message.CHECKOUT_BOOK_SUCCESS;
        }
        return Message.CHECKOUT_BOOK_UNSUCCESS;
    }

    @Override
    public String toString() {
        return "Checkout " + catalog.getClass().toString();
    }
}
