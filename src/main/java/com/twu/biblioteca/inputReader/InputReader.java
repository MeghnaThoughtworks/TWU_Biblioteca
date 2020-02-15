package com.twu.biblioteca.inputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String getTitle() throws IOException {
        System.out.println("Enter title: ");
        return bufferedReader.readLine();
    }

    public String getUserNumber() throws IOException {
        System.out.println("Enter library number");
        return bufferedReader.readLine();
    }

    public String getUserPassword() throws IOException {
        System.out.println("Enter library password");
        return bufferedReader.readLine();
    }
}
