package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.title = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return title + " " + author +
                " " + yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title.toLowerCase(), book.title.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
