package com.twu.biblioteca.core;

import com.twu.biblioteca.interfaces.Option;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<Option> option;

    public Menu(ArrayList<Option> option) {
        this.option = option;
    }

    public ArrayList<Option> getOptions() {
        return option;
    }
}
