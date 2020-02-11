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
    public void init(){
        title = "Alchemist";
        author = "Paulo Coelho";
        yearPublished = 1988;
    }

    @Test
    public void shouldReturnBookTitle() {
        Book book1 = new Book(title,author,yearPublished);
        String title = "Alchemist";

        assertThat(title, is(equalTo(book1.getTitle())));
    }
    @Test
    public void shouldReturnAuthorAndYearOfBookPublished() {
        Book book1 = new Book(title,author,yearPublished);

        assertThat(title,is(equalTo(book1.getTitle())));
        assertThat(yearPublished,is(equalTo(book1.getYearPublished())));
    }
}