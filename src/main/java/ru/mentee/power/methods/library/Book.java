package ru.mentee.power.methods.library;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        String title1 = (title == null) ? "<null>" : title;
        String author1 = (author == null) ? "<null>" : author;
        String year1 = (year == 0 && title == null) ? "<null>" :
                String.valueOf(year);
        return "\"" + title1 + "\" (" + year1 + "), " + author1 +
                " - " + (available ? "доступна" : "выдана");
    }
}