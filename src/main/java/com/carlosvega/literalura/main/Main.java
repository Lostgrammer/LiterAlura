package com.carlosvega.literalura.main;

import com.carlosvega.literalura.converter.JsonConverter;
import com.carlosvega.literalura.models.BookData;
import com.carlosvega.literalura.models.BookList;
import com.carlosvega.literalura.service.ReadApi;

public class Main {
    //variables and constants
    private final String URL_BASE = "https://gutendex.com/books/";
    ReadApi apireader = new ReadApi();
    JsonConverter jsonConverter = new JsonConverter();

    public void showMenu(){
        var json = apireader.obtenerDatos(URL_BASE);
        var serializado = jsonConverter.obtenerDatos(json, BookList.class);
        System.out.println(serializado);
    }
}
