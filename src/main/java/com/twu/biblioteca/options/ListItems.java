package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.interfaces.OutputUI;

public class ListItems<T extends LibraryItem> implements Option {
    private final Catalog<T> libraryObject;
    private String display;
    private OutputUI outputUI;

    public ListItems(Catalog<T> libraryObject1, String display, OutputUI outputUI) {
        this.libraryObject = libraryObject1;
        this.display = display;
        this.outputUI = outputUI;
    }

    @Override
    public void onSelect() {
        outputUI.display(libraryObject.toString());
    }

    @Override
    public String toString() {
        return display;
    }
}
