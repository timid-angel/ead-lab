package com.ead;

public class Book {
    private int id;
    private String bookName;
    private String bookEdition;
    private float bookPrice;

    public Book(int id, String bookName, String bookEdition, float bookPrice) {
        this.id = id;
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPrice = bookPrice;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public float getBookPrice() {
        return bookPrice;
    }
}