package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksFeeder {

    static ArrayList<Book> books() {
        Book book1 = new Book("Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Murder on the Orient Express", "Agatha Christie", 1956);
        Book book3 = new Book("IT", "Stephen King", 1986);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }
}
