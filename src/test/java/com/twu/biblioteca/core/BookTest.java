package com.twu.biblioteca.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class BookTest {
    String title;
    String author;
    Integer yearPublished;

    @BeforeEach
    public void init() {
        title = "Alchemist";
        author = "Paulo Coelho";
        yearPublished = 1988;
    }

    @Test
    public void shouldEquateTwoBooks() {
        Book book1 = new Book(title, author, yearPublished);
        Book book2 = new Book(title,"",0);

        assertThat(book1, is(equalTo(book2)));
        assertThat(book1.hashCode(),is(equalTo(book2.hashCode())));
    }

    @Test
    public void shouldDisplayBook(){
        Book book1 = new Book(title,author,yearPublished);
        String bookDescription = String.format("%-30s%-30s%-30s",title,author,yearPublished);

        assertThat(bookDescription,is(equalTo(book1.toString())));
    }

    @Test
    public void shouldReturnBook() {
        Book book1 = new Book(title, author, yearPublished);
        String title = "Alchemist";

        assertThat(book1, is(equalTo(book1.match(title.toLowerCase()))));
    }

    @Test
    public void shouldNotReturnBook(){
        Book book1 = new Book(title, author, yearPublished);
        String title = "it";

        assertThat(book1, is(not(equalTo(book1.match(title.toLowerCase())))));
    }

    @Test
    public void shouldReturnBookIfTitleMatch(){
        Book book1 = new Book(title,author,yearPublished);

        assertThat(book1.match(title),is(equalTo(book1)));
    }
}