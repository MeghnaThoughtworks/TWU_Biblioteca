package com.twu.biblioteca.core;

import java.util.Objects;

public class User {
    private final String libraryNumber;
    private final String password;

    public User(String password, String libraryNumber) {
        this.password = password;
        this.libraryNumber = libraryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(libraryNumber, user.libraryNumber) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
