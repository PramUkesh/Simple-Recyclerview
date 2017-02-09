package me.nielssg.simplerecyclerview;

public class Book {
    private String title;
    private String author;
    private int yearOfPublication;
    private int amountOfPages;

    public Book(String title, String author, int yearOfPublication, int amountOfPages) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.amountOfPages = amountOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }
}
