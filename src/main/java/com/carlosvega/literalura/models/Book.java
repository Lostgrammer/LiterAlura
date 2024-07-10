package com.carlosvega.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    //variables
    @Id
    private Long id;
    @Column(unique = true)
    private String title;
    private String copyright;
    @OneToMany(mappedBy = "book")
    private List<AuthorData> authorDataList;

    public Book(){}

    //constructor
    public Book(BookData bookData) {
        this.id = Long.valueOf(bookData.id());
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
