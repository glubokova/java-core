package ru.mentee.power.methods.library;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public boolean addBook(Book book) {
        if (bookCount >= books.length) {
            return false;
        }
        books[bookCount] = book;
        bookCount++;
        return true;
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean checkoutBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null || !book.isAvailable()) {
            return false;
        }
        book.setAvailable(false);
        return true;
    }

    public boolean returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null || book.isAvailable()) {
            return false;
        }
        book.setAvailable(true);
        return true;
    }

    public Book[] listAvailableBooks() {
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) count++;
        }
        Book[] result = new Book[count];
        int idx = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                result[idx++] = books[i];
            }
        }
        return result;
    }

    public Book[] listCheckedOutBooks() {
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isAvailable()) count++;
        }
        Book[] result = new Book[count];
        int idx = 0;
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isAvailable()) {
                result[idx++] = books[i];
            }
        }
        return result;
    }
}