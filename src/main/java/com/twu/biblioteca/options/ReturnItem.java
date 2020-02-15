package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.ItemCantReturnException;
import com.twu.biblioteca.core.User;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.interfaces.OutputUI;

import java.io.IOException;
import java.util.ArrayList;

public class ReturnItem<T extends LibraryItem> implements Option {
    private final Catalog<T> catalog;
    private final InputReader inputReader;
    private String display;
    private OutputUI outputUI;
    private final ArrayList<User> users;

    public ReturnItem(Catalog<T> catalog, InputReader inputReader, String display, OutputUI outputUI, ArrayList<User> users) {
        this.catalog = catalog;
        this.inputReader = inputReader;
        this.display = display;
        this.outputUI = outputUI;
        this.users = users;
    }

    @Override
    public void onSelect() throws IOException, UserNotFoundException {
        String number = inputReader.getUserNumber();
        String password = inputReader.getUserPassword();
        if (!login(number, password))
            throw new UserNotFoundException("User not found!");
        String title = inputReader.getTitle();
        try {
            catalog.returnItem(title);
            outputUI.display(Message.RETURN_BOOK_SUCCESS);
        } catch (ItemCantReturnException e) {
            outputUI.display(Message.RETURN_BOOK_UNSUCCESS);
        }
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
        return display;
    }
}

