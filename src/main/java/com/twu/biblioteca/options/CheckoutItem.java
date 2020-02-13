package com.twu.biblioteca.options;

import com.twu.biblioteca.core.User;
import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.Option;

import java.io.IOException;
import java.util.ArrayList;

public class CheckoutItem<T extends LibraryItem> implements Option {
    private final Catalog<T> catalog;
    private final InputReader inputReader;
    private final ArrayList<User> users;

    public CheckoutItem(Catalog<T> catalog, InputReader inputReader, ArrayList<User> users) {
        this.catalog = catalog;
        this.inputReader = inputReader;
        this.users = users;
    }

    @Override
    public String onSelect() throws IOException, UserNotFoundException {
        String number = "123";
        String password = "12";
        if (!login(number, password))
            throw new UserNotFoundException("User not found!");
        String title = inputReader.getInput();
        catalog.checkoutItem(title);
        if (catalog.checkedItemStatus(title)) {
            return Message.CHECKOUT_BOOK_SUCCESS;
        }
        return Message.CHECKOUT_BOOK_UNSUCCESS;
    }

    private boolean login(String number, String password) {
        for (User user : users) {
            if (user.equals(new User(number, password)))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Checkout";
    }
}
