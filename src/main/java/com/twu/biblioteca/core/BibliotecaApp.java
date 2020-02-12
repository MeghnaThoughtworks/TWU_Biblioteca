package com.twu.biblioteca;

import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Library;
import com.twu.biblioteca.interfaces.BibliotecaUI;
import com.twu.biblioteca.interfaces.Menu;
import com.twu.biblioteca.options.*;

import java.io.IOException;
import java.util.ArrayList;

import static com.twu.biblioteca.BooksFeeder.books;

public class BibliotecaApp {
    private static final InputReader inputReader = new InputReader();
    private static final Library library = new Library(books());
    private static final Option optionOne = new ListBooks(library);
    private static final Option optionThree = new Quit();
    private static final Option optionTwo = new CheckoutBook(library, inputReader);
    private static final Option optionFour = new ReturnBook(library, inputReader);

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
