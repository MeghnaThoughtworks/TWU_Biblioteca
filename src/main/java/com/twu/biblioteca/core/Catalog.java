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
        for (T libraryObject : libraryObjects) {
            if (libraryObject.match(title.toLowerCase()) != null)
                return libraryObject;
        }
        return null;
    }

    public void checkoutItem(String title) {
        T libraryObject = findItem(title, availableLibraryObjects);
        if (libraryObject != null) {
            availableLibraryObjects.remove(libraryObject);
            checkedOutLibraryObject.add(libraryObject);
        }
    }

    public boolean checkedItemStatus(String title) {
        for (T libraryObject : checkedOutLibraryObject) {
            if (libraryObject.match(title.toLowerCase()) != null)
                return true;
        }
        return false;
    }

    public void returnItem(String title) {
        T libraryObject = findItem(title, checkedOutLibraryObject);
        if (libraryObject != null) {
            checkedOutLibraryObject.remove(libraryObject);
            availableLibraryObjects.add(libraryObject);
        }
    }

    public boolean returnItemStatus(String title) {
        for (T libraryObject : availableLibraryObjects) {
            if (libraryObject.match(title.toLowerCase()) != null)
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
