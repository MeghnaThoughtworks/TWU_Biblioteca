package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

import static com.twu.biblioteca.BooksFeeder.books;

public class BibliotecaApp {
    private static final Library library = new Library(books());
    private static final Option optionOne = new ListBooks(library);
    private static final Option optionThree = new Quit();
    private static final Option optionTwo = new CheckoutBook(library);
    private static final Option optionFour = new ReturnBook(library);

    public static void main(String[] args) throws IOException {
        ArrayList<Option> options = new ArrayList<>();
        options.add(optionOne);
        options.add(optionTwo);
        options.add(optionThree);
        options.add(optionFour);

        Menu menu = new Menu(options);
        BibliotecaUI bibliotecaUI = new BibliotecaUI(menu);
        bibliotecaUI.display();
    }
}
