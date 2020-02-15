package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.Option;

import java.io.IOException;

public class ReturnItem<T extends LibraryItem> implements Option {
    private final Catalog<T> catalog;
    private final InputReader inputReader;
    private String display;

    public ReturnItem(Catalog<T> catalog, InputReader inputReader, String display) {
        this.catalog = catalog;
        this.inputReader = inputReader;
        this.display = display;
    }

    @Override
    public String onSelect() throws IOException {
        String title = inputReader.getTitle();
        catalog.returnItem(title);
        if (catalog.returnItemStatus(title)) {
            return Message.RETURN_BOOK_SUCCESS;
        }
        return Message.RETURN_BOOK_UNSUCCESS;
    }

    @Override
    public String toString() {
        return display;
    }
}

