package com.roma.storage;

import java.util.Arrays;

public class Book {
    private String name;
    public String[] author;
    private int pages;
    private int year;

    void setName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Значение name < 3");
        }
        this.name = name;
    }
    /*void setAuthors(Author... author) {
       if (author == null) {
            throw new IllegalArgumentException("Значение authors < 3");
        }
        this.author = Author;
    }*/
    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setYear(int year) {
        this.year = year;
    }



    @Override
    public String toString() {
        return "КНИГА: " +
                "НАЗВАНИЕ: " + name + '\'' +
                ", АВТОР: " + author +
                ", КОЛ-ВО СТРАНИЦ: " + pages +
                ", ПЕРВАЯ ПУБЛИКАЦИЯ: " + year;
    }

}
