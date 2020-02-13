package com.twu.biblioteca.options;

import com.twu.biblioteca.core.Catalog;
import com.twu.biblioteca.core.LibraryObject;

public class ListBooks<T extends LibraryObject> implements Option {
    private final Catalog<T> libraryObject;

    public ListBooks(Catalog<T> libraryObject1) {
        this.libraryObject = libraryObject1;
    }

    @Override
    public String execute() {
        return libraryObject.toString();
    }

    @Override
    public String toString() {
        return "List " + libraryObject.getClass().getSuperclass().toString();
    }
}
