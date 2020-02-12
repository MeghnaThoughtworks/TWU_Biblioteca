package com.twu.biblioteca;

public class ListBooks implements Option {
    private final Library library;

    public ListBooks(Library library) {
        this.library = library;
    }

    @Override
    public String execute() {
        return library.toString();
    }

    @Override
    public String toString() {
        return "List Books";
    }
}
