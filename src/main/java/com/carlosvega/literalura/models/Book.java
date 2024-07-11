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
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authorList;

    public Book(){}

    //constructor
    public Book(BookData bookData) {
        this.id = Long.valueOf(bookData.id());
        this.title = bookData.title();
        this.copyright = bookData.copyright();
    }

    //getter setter
    public List<Author> getAuthorList() {
        return authorList;
    }
    public void setAuthorList(List<Author> authorList) {
        authorList.forEach(a -> a.setBook(this));
        this.authorList = authorList;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCopyright() {
        return copyright;
    }
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + title + '\'' +
                ", copyright='" + copyright + '\'' +
                ", autor(es)=" + authorList;
    }
}
