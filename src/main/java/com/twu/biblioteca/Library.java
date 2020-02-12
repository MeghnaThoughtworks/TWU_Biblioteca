package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void checkout(Book bookEntered) {
        Book checkedOutBook = null;
        for (Book book : books) {
            if (book.equals(bookEntered))
                checkedOutBook = book;
        }
        if (checkedOutBook != null) {
            books.remove(checkedOutBook);
            checkedOutBooks.add(checkedOutBook);
        }
    }

    public boolean checkedBookOut(Book bookEntered) {
        for (Book book : checkedOutBooks) {
            if (book.equals(bookEntered))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Book book : books) {
            stringBuilder.append("(").append(i + 1).append(") ").append(book).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
