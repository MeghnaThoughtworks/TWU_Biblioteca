package com.twu.biblioteca;

public class Book {
    private final String title;
    private final String author;
    private final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.title = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
