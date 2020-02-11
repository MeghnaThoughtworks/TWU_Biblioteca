package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static final Option option = new ListBooks();

    public static void main(String[] args) {
        ArrayList<Option> options = new ArrayList<>();
        options.add(option);
        Menu menu = new Menu(options);
        BibliotecaUI bibliotecaUI = new BibliotecaUI(menu);
        bibliotecaUI.display();
    }
}
