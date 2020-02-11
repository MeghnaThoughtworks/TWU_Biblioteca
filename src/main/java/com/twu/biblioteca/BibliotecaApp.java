package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private static final Option optionTwo = new ListBooks();
    private static final Option optionOne = new Quit();

    public static void main(String[] args) {
        ArrayList<Option> options = new ArrayList<>();
        options.add(optionOne);
        options.add(optionTwo);
        Menu menu = new Menu(options);
        BibliotecaUI bibliotecaUI = new BibliotecaUI(menu);
        bibliotecaUI.display();
    }
}
