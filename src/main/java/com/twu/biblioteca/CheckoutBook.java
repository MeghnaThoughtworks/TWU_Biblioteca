package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckoutBook implements Option {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Library library;

    public CheckoutBook(Library library) {
        this.library = library;
    }

    @Override
    public String execute() throws IOException {
        System.out.println("Enter the title of the book: ");
        if (checkoutBook()) {
            return Message.CHECKOUT_BOOK_SUCCESS;
        }
        return Message.CHECKOUT_BOOK_UNSUCCESS;
    }

    public boolean checkoutBook() throws IOException {
        String title = reader.readLine();
        library.checkout(new Book(title,"",0));
        return library.checkedBookOut(new Book(title,"",0));
    }

    @Override
    public String toString() {
        return "Checkout Book";
    }
}
