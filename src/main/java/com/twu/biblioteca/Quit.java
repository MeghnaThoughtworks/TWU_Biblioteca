package com.twu.biblioteca;

public class Quit implements Option {
    @Override
    public String execute() {
        quit();
        return "";
    }

    public void quit(){
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
