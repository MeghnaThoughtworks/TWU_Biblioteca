package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.LibraryItem;
import com.twu.biblioteca.interfaces.Option;

public class ListItems<T extends LibraryItem> implements Option {
    private final Catalog<T> libraryObject;
    private String display;

    public ListItems(Catalog<T> libraryObject1,String display) {
        this.libraryObject = libraryObject1;
        this.display = display;
    }

    @Override
    public String onSelect() {
        return libraryObject.toString();
    }

    @Override
    public String toString() {
        return display;
    }
}
