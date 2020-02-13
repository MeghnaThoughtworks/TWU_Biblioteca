package com.twu.biblioteca.interfaces;

import com.twu.biblioteca.core.Menu;
import com.twu.biblioteca.options.Option;

import java.io.IOException;
import java.util.Scanner;

import static com.twu.biblioteca.data.Message.WELCOME_MESSAGE;

public class Biblioteca {
    private static Scanner scanner = new Scanner(System.in);
    private final Menu menu;

    public Biblioteca(Menu menu) {
        this.menu = menu;
    }

    public void display() throws IOException {
        System.out.println(WELCOME_MESSAGE);
        printMenu();
    }

    private void printMenu() throws IOException {
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("##########MENU##########");
            int i = 0;
            for (Option option : menu.getOptions()) {
                System.out.println("(" + (i + 1) + ")" + option.toString());
                i++;
            }
            System.out.println("########################");
            int choice = Integer.parseInt(scanner.next());
            if (choice - 1 >= menu.getOptions().size()) {
                System.out.println("Please enter a valid option!");
            }
            System.out.println("-------------------------");
            System.out.println(menu.getOptions().get(choice - 1).onSelect());
            System.out.println("--------------------------");
        }
    }
}
