package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.Option;

public class Quit implements Option {
    @Override
    public String onSelect() {
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
