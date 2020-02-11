package com.twu.biblioteca;

import java.util.Scanner;

import static com.twu.biblioteca.BooksFeeder.books;
import static com.twu.biblioteca.Message.WELCOME_MESSAGE;

public class BibliotecaUI {
    private static Library library = new Library(books());
    private static Scanner scanner = new Scanner(System.in);
    private final Menu menu;

    public BibliotecaUI(Menu menu) {
        this.menu = menu;
    }

    public void display() {
        System.out.println(WELCOME_MESSAGE);
        printMenu();
    }

    public static void printBooks() {
        int i = 0;
        for (Book book : library.getBooks()) {
            System.out.println("(" + (i + 1) + ") " + book.getTitle());
            i++;
        }
    }

    private void printMenu() {
        System.out.println("MENU");
        int i = 0;
        for (Option option : menu.getOptions()) {
            System.out.println("(" + (i + 1) + ")" + option.toString());
            i++;
        }
        int choice = Integer.parseInt(scanner.next());
        menu.getOptions().get(choice - 1).execute();
    }
}
