package com.twu.biblioteca.interfaces;

import com.twu.biblioteca.options.UserNotFoundException;

import java.io.IOException;

public interface Option {
    String onSelect() throws IOException, UserNotFoundException;
}
