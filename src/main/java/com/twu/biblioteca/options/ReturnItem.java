package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.interfaces.OutputUI;

import java.io.IOException;

public class ReturnItem<T extends LibraryItem> implements Option {
    private final Catalog<T> catalog;
    private final InputReader inputReader;
    private String display;
    private OutputUI outputUI;

    public ReturnItem(Catalog<T> catalog, InputReader inputReader, String display, OutputUI outputUI) {
        this.catalog = catalog;
        this.inputReader = inputReader;
        this.display = display;
        this.outputUI = outputUI;
    }

    @Override
    public void onSelect() throws IOException {
        String title = inputReader.getTitle();
        catalog.returnItem(title);
        if (catalog.returnItemStatus(title)) {
            outputUI.display(Message.RETURN_BOOK_SUCCESS);
            return;
        }
        outputUI.display(Message.RETURN_BOOK_UNSUCCESS);
    }

    @Override
    public String toString() {
        return display;
    }
}

