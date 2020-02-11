package com.twu.biblioteca;

public class Quit implements Option {
    @Override
    public void execute() {
        BibliotecaUI.quit();
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
