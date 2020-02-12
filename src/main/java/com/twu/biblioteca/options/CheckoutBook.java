package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Option {
    private InputReader inputReader;
    private Library library;

    public CheckoutBook(Library library, InputReader inputReader) {
        this.library = library;
        this.inputReader = inputReader;
    }

    @Override
    public String execute() throws IOException {
        String title = inputReader.getInput();
        Book checkedOutBook = library.findBook(title);
        if (checkedOutBook != null) {
            library.checkout(checkedOutBook);
            if (library.checkedBookStatus(checkedOutBook)) {
                return Message.CHECKOUT_BOOK_SUCCESS;
            }
        }
        return Message.CHECKOUT_BOOK_UNSUCCESS;
    }


    @Override
    public String toString() {
        return "Checkout Book";
    }
}
