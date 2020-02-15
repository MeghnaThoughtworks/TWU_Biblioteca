package com.twu.biblioteca.core;

import com.twu.biblioteca.interfaces.LibraryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Catalog<T extends LibraryItem> {
    private final ArrayList<T> availableLibraryObjects;
    private final HashMap<T, User> checkedOutLibraryObjects = new HashMap<>();

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

    public void checkoutItem(String title, User user) {
        T libraryItem = findItem(title, availableLibraryObjects);
        if (libraryItem != null) {
            availableLibraryObjects.remove(libraryItem);
            checkedOutLibraryObjects.put(libraryItem, user);
        }
    }

    public boolean checkedItemStatus(String title, User user) {
        for (Map.Entry<T, User> entry : checkedOutLibraryObjects.entrySet()) {
            if ((entry.getKey().match(title.toLowerCase())) != null && user.equals(entry.getValue()))
                return true;
        }
        return false;
    }

    public void returnItem(String title) {
        T item = null;
        for (Map.Entry<T, User> entry : checkedOutLibraryObjects.entrySet()) {
            if (entry.getKey().match((title.toLowerCase())) != null) {
                item = entry.getKey();
            }
        }
        if (item != null) {
            availableLibraryObjects.add(item);
            checkedOutLibraryObjects.remove(item);
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
        for (T libraryObject : availableLibraryObjects) {
            stringBuilder.append(libraryObject).append("\n");
        }
        return stringBuilder.toString();
    }
}
