package com.carlosvega.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record BookData(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String title,
        @JsonAlias("copyright") String copyright,
        @JsonAlias("authors") List<AuthorData> authorDataList
) {
}
