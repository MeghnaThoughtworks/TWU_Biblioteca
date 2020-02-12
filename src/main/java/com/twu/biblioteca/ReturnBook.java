package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReturnBook implements Option{
    private final Library library;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ReturnBook(Library library) {
        this.library = library;
    }

    @Override
    public String execute() throws IOException {
        if(returnBook())
            return Message.RETURN_BOOK_SUCCESS;
        else
            return Message.RETURN_BOOK_UNSUCCESS;
    }

    public boolean returnBook() throws IOException {
        System.out.println("Enter the title of the book: ");
        String title = reader.readLine();
        library.returnBook(new Book(title,"",0));
        return library.returnedBook(new Book(title,"",0));
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
