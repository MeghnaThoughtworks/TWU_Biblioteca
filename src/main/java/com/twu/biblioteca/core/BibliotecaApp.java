package com.twu.biblioteca.core;

import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.interfaces.Biblioteca;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.interfaces.OutputUI;
import com.twu.biblioteca.options.*;

import java.io.IOException;
import java.util.ArrayList;

import static com.twu.biblioteca.data.DataFeeder.*;

public class BibliotecaApp {
    private static final OutputUI outputUI = new OutputUI();
    private static final InputReader inputReader = new InputReader();
    private static final Catalog<Book> catalogBook = new Catalog<>(books());
    private static final Catalog<Movie> catalogMovie = new Catalog<>(movies());
    private static final Option optionOne = new ListItems<>(catalogBook, "List Books", outputUI);
    private static final Option optionTwo = new CheckoutItem<>(catalogBook, inputReader, users(), "Checkout Book", outputUI);
    private static final Option optionThree = new Quit();
    private static final Option optionFour = new ReturnItem<>(catalogBook, inputReader, "Return Book", outputUI, users());
    private static final Option optionFive = new ListItems<>(catalogMovie, "List Movie", outputUI);
    private static final Option optionSix = new CheckoutItem<>(catalogMovie, inputReader, users(), "Checkout Movie", outputUI);
    private static final Option optionSeven = new ReturnItem<>(catalogMovie, inputReader, "Return Movie", outputUI, users());

    public static void main(String[] args) throws IOException {
        ArrayList<Option> options = new ArrayList<>();
        options.add(optionOne);
        options.add(optionTwo);
        options.add(optionFour);
        options.add(optionFive);
        options.add(optionSix);
        options.add(optionSeven);
        options.add(optionThree);
        Menu menu = new Menu(options);
        Biblioteca biblioteca = new Biblioteca(menu);

        biblioteca.display();
    }
}
