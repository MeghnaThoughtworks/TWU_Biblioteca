package com.twu.biblioteca.options;

import com.twu.biblioteca.core.LibraryObject;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;

import java.io.IOException;

public class CheckoutBook<T extends LibraryObject> implements Option {
    private final Catalog<T> libraryBook;
    private final InputReader inputReader;

    public CheckoutBook(Catalog<T> libraryBook, InputReader inputReader) {
        this.libraryBook = libraryBook;
        this.inputReader = inputReader;
    }

    @Override
    public String execute() throws IOException {
        String title = inputReader.getInput();
        libraryBook.checkout(title);
        if (libraryBook.checkedLibraryObjectStatus(title)) {
            return Message.CHECKOUT_BOOK_SUCCESS;
        }
        return Message.CHECKOUT_BOOK_UNSUCCESS;
    }

    @Override
    public String toString() {
        return "Checkout " + libraryBook.getClass().toString();
    }
}
