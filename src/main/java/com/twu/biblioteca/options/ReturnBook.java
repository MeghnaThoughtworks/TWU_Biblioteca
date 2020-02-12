package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBook implements Option {
    private Library library;
    private InputReader inputReader;

    public ReturnBook(Library library, InputReader inputReader) {
        this.library = library;
        this.inputReader = inputReader;
    }

    @Override
    public String execute() throws IOException {
        System.out.println("Enter the title of the book: ");
        String title = inputReader.getInput();
        Book returnedBook = library.findBook(title);
        System.out.println(returnedBook);
        if (returnedBook != null) {
            library.returnBook(returnedBook);
            if (library.returnedBookStatus(returnedBook)) {
                return Message.RETURN_BOOK_SUCCESS;
            }
        }
        return Message.RETURN_BOOK_UNSUCCESS;
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
