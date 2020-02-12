package com.twu.biblioteca.interfaces;

import com.twu.biblioteca.options.Option;

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
