package com.carlosvega.literalura.models;


import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    @ManyToOne
    private Book book;

    public Author(){}

    public Author(AuthorData a) {
        this.name = a.name();
        this.birthYear = a.birthYear();
    }
    //getters setter
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", birthYear=" + birthYear;
    }
}
