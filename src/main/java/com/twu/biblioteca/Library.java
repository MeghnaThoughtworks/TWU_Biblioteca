package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void checkout(String title) {
        Book bookCheckedOut = null;
        for (Book book : this.getBooks()) {
            if (book.getTitle().toLowerCase().equals(title))
                bookCheckedOut = book;
        }
        if (bookCheckedOut != null) {
            this.getBooks().remove(bookCheckedOut);
//            this.checkedOutBooks.add(bookCheckedOut);
        }
    }
}
