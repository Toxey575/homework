package com.roma.lib;

import java.util.Arrays;

public class Book {
    private String title;
    private int pageCount;
    private int year;
    private Author[] authors;

    public Book(String title, int authorsCount) {
        this.title = title;
        authors = new Author[authorsCount];
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addAuthor (Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return;
            }
        }
    }

    public Author[] getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", year=" + year +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
}
