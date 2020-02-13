package com.twu.biblioteca.core;

import java.util.ArrayList;

public class Library<T extends LibraryObject> {
    private final ArrayList<T> availableLibraryObjects;
    private final ArrayList<T> checkedOutLibraryObject = new ArrayList<>();

    public Library(ArrayList<T> availableLibraryObjects) {
        this.availableLibraryObjects = availableLibraryObjects;
    }

    private T findLibraryObject(String title, ArrayList<T> libraryObjects) {
        for (T libraryObject : libraryObjects) {
            if (libraryObject.search(title.toLowerCase()) != null)
                return libraryObject;
        }
        return null;
    }

    public void checkout(String title) {
        T libraryObject = findLibraryObject(title, availableLibraryObjects);
        if (libraryObject != null) {
            availableLibraryObjects.remove(libraryObject);
            checkedOutLibraryObject.add(libraryObject);
        }
    }

    public boolean checkedLibraryObjectStatus(String title) {
        for (T libraryObject : checkedOutLibraryObject) {
            if (libraryObject.search(title.toLowerCase()) != null)
                return true;
        }
        return false;
    }

    public void returnBook(String title) {
        T libraryObject = findLibraryObject(title, checkedOutLibraryObject);
        if (libraryObject != null) {
            checkedOutLibraryObject.remove(libraryObject);
            availableLibraryObjects.add(libraryObject);
        }
    }

    public boolean returnedBookStatus(String title) {
        for (T libraryObject : availableLibraryObjects) {
            if (libraryObject.search(title.toLowerCase()) != null)
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
