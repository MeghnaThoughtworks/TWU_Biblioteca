package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.twu.biblioteca.BooksFeeder.books;
import static com.twu.biblioteca.Message.WELCOME_MESSAGE;

public class BibliotecaUI {
    private static Library library = new Library(books());
    private static Scanner scanner = new Scanner(System.in);
    private final Menu menu;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean loop = true;

    public BibliotecaUI(Menu menu) {
        this.menu = menu;
    }

    public static void quit() {
        loop = false;
    }

    public static void checkoutBook() throws IOException {
        String title = reader.readLine();
        library.checkout(title.toLowerCase());
//        for (Book book : library.getCheckedOutBooks()) {
//            System.out.println(book.getTitle());
//        }
    }

    public void display() throws IOException {
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

    private void printMenu() throws IOException {
        do {
            System.out.println("MENU");
            int i = 0;
            for (Option option : menu.getOptions()) {
                System.out.println("(" + (i + 1) + ")" + option.toString());
                i++;
            }
            int choice = Integer.parseInt(scanner.next());
            if (choice - 1 >= menu.getOptions().size()) {
                loop = true;
                System.out.println("Please enter a valid option!");
                continue;
            }
            menu.getOptions().get(choice - 1).execute();
        } while (loop);

    }
}
