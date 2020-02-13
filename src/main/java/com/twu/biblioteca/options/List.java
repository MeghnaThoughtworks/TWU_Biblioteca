package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.interfaces.LibraryItem;

public class List<T extends LibraryItem> implements Option {
    private final Catalog<T> libraryObject;

    public List(Catalog<T> libraryObject1) {
        this.libraryObject = libraryObject1;
    }

    @Override
    public String onSelect() {
        return libraryObject.toString();
    }

    @Override
    public String toString() {
        return "List " + libraryObject.getClass().getSuperclass().toString();
    }
}
