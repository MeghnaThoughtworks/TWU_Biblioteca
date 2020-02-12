package com.twu.biblioteca.core;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    private Book findBook(String title, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.equals(new Book(title, "", 0)))
                return book;
        }
        return null;
    }

    public void checkout(String title) {
        Book checkedOutBook = findBook(title, availableBooks);
        if (checkedOutBook != null) {
            availableBooks.remove(checkedOutBook);
            checkedOutBooks.add(checkedOutBook);
        }
    }

    public boolean checkedBookStatus(String title) {
        for (Book book : checkedOutBooks) {
            if (book.equals(new Book(title,"" ,0)))
                return true;
        }
        return false;
    }

    public void returnBook(String title) {
        Book returnedBook = findBook(title, checkedOutBooks);
        if (returnedBook != null) {
            checkedOutBooks.remove(returnedBook);
            availableBooks.add(returnedBook);
        }
    }

    public boolean returnedBookStatus(String title) {
        for (Book book : availableBooks) {
            if (book.equals(new Book(title,"",0)))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Book book : availableBooks) {
            stringBuilder.append("(").append(i + 1).append(") ").append(book).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
