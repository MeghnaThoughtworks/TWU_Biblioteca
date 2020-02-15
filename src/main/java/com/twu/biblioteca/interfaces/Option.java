package com.twu.biblioteca.interfaces;

import com.twu.biblioteca.exceptions.UserNotFoundException;

import java.io.IOException;

public interface Option {
    void onSelect() throws IOException, UserNotFoundException;
}
