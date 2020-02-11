package com.twu.biblioteca;

public class ListBooks implements Option {
    @Override
    public void execute() {
        BibliotecaUI.printBooks();
    }

    @Override
    public String toString() {
        return "List Of Books";
    }
}
