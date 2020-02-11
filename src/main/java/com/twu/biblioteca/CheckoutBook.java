package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Option{
    @Override
    public void execute() throws IOException {
        BibliotecaUI.checkoutBook();
    }

    @Override
    public String toString() {
        return "Checkout Book";
    }
}
