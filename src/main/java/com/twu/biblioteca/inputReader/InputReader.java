package com.twu.biblioteca.inputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String getInput() throws IOException {
        System.out.println("Enter title of the book:");
        return bufferedReader.readLine();
    }
}
