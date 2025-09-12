package ru.mentee.power.methods.library;

public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library(10);
        Book b1 = new Book("Война и мир", "Лев Толстой", 1869);
        Book b2 = new Book("Преступление и наказание", "Ф.М.Достоевский", 1866);
        Book b3 = new Book("Мастер и Маргарита", "М.А.Булгаков", 1967);

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        System.out.println("=== Доступные книги ===");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }

        System.out.println("\nВыдаём 'Война и мир' ... " + lib.checkoutBook("война и мир"));

        System.out.println("\n=== Доступны ===");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }
        System.out.println("\n=== Выданы ===");
        for (Book b : lib.listCheckedOutBooks()) {
            System.out.println(b);
        }

        System.out.println("\nВозвращаем 'Война и мир' ... " + lib.returnBook("война и мир"));

        System.out.println("\n=== После возврата доступны ===");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }
    }
}