package com.carlosvega.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Book {
    //variables
    private Integer id;
    private String title;
    private String copyright;
    private List<AuthorData> authorDataList;

    //constructor
    public Book(BookData bookData) {
        this.id = bookData.id();
        this.title = bookData.title();
        this.copyright = bookData.copyright();
        this.authorDataList = bookData.authorDataList();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + title + '\'' +
                ", copyright='" + copyright + '\'' +
                ", autor(es)=" + authorDataList;
    }
}
