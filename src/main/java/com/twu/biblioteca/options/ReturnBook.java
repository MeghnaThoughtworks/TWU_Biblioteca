package com.twu.biblioteca.options;

import com.twu.biblioteca.data.Message;
import com.twu.biblioteca.inputReader.InputReader;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Library;

import java.io.IOException;

public class ReturnBook implements Option {
    private final Library library;
    private final InputReader inputReader;

    public ReturnBook(Library library, InputReader inputReader) {
        this.library = library;
        this.inputReader = inputReader;
    }

    @Override
    public String execute() throws IOException {
        String title = inputReader.getInput();
        library.returnBook(title);
        if (library.returnedBookStatus(title)) {
            return Message.RETURN_BOOK_SUCCESS;
        }
        return Message.RETURN_BOOK_UNSUCCESS;
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
