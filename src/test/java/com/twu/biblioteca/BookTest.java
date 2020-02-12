package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
        String bookDescription = title+" "+author+" "+yearPublished;

        assertThat(bookDescription,is(equalTo(book1.toString())));
    }
}