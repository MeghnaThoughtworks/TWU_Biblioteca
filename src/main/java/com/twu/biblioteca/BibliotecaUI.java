package com.twu.biblioteca;

import static com.twu.biblioteca.BooksFeeder.books;
import static com.twu.biblioteca.Message.WELCOME_MESSAGE;

public class BibliotecaUI {
    static Library library = new Library(books());

    public void display() {
        System.out.println(WELCOME_MESSAGE);
        printBooks();
    }

    public static void printBooks() {
        int i = 0;
        for (Book book : library.getBooks()) {
            System.out.println("(" + (i + 1) + ") " + book.getTitle());
            i++;
        }
    }
}
