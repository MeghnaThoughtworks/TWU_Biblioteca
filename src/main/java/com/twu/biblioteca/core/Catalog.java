package com.twu.biblioteca.core;

import com.twu.biblioteca.interfaces.LibraryItem;

import java.util.ArrayList;

public class Catalog<T extends LibraryItem> {
    private final ArrayList<T> availableLibraryObjects;
    private final ArrayList<T> checkedOutLibraryObject = new ArrayList<>();

    public Catalog(ArrayList<T> availableLibraryObjects) {
        this.availableLibraryObjects = availableLibraryObjects;
    }

    private T findItem(String title, ArrayList<T> libraryObjects) {
        for (T libraryItem : libraryObjects) {
            if (libraryItem.match(title.toLowerCase()) != null)
                return libraryItem;
        }
        return null;
    }

    public void checkoutItem(String title) {
        T libraryItem = findItem(title, availableLibraryObjects);
        if (libraryItem != null) {
            availableLibraryObjects.remove(libraryItem);
            checkedOutLibraryObject.add(libraryItem);
        }
    }

    public boolean checkedItemStatus(String title) {
        for (T libraryItem : checkedOutLibraryObject) {
            if (libraryItem.match(title.toLowerCase()) != null)
                return true;
        }
        return false;
    }

    public void returnItem(String title) {
        T libraryItem = findItem(title, checkedOutLibraryObject);
        if (libraryItem != null) {
            checkedOutLibraryObject.remove(libraryItem);
            availableLibraryObjects.add(libraryItem);
        }
    }

    public boolean returnItemStatus(String title) {
        for (T libraryItem : availableLibraryObjects) {
            if (libraryItem.match(title.toLowerCase()) != null)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (T libraryObject : availableLibraryObjects) {
            stringBuilder.append("(").append(i + 1).append(") ").append(libraryObject).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
