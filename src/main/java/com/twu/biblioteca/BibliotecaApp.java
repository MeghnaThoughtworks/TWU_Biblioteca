package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaApp {
    private static final Option optionOne = new ListBooks();
    private static final Option optionThree = new Quit();
    private static final Option optionTwo = new CheckoutBook();

    public static void main(String[] args) throws IOException {
        ArrayList<Option> options = new ArrayList<>();
        options.add(optionOne);
        options.add(optionTwo);
        options.add(optionThree);

        Menu menu = new Menu(options);
        BibliotecaUI bibliotecaUI = new BibliotecaUI(menu);
        bibliotecaUI.display();
    }
}
