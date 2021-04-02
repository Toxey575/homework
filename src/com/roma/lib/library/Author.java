package com.roma.lib.library;

public class Author {
    private String name;
    private String surName;

    public Author(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }



    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
