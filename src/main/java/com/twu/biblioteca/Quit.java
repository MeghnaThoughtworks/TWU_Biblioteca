package com.twu.biblioteca;

public class Quit implements Option {
    @Override
    public void execute() {
        quit();
    }

    public void quit(){
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
