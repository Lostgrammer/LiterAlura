package com.carlosvega.literalura.models;



public class Author {
    private Long id;
    private String name;
    private Integer birthYear;

    public Author(AuthorData a) {
        this.name = a.name();
        this.birthYear = a.birthYear();
    }
}
