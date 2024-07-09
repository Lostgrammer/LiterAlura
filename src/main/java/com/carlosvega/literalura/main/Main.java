package com.carlosvega.literalura.main;

import com.carlosvega.literalura.converter.JsonConverter;
import com.carlosvega.literalura.models.BookData;
import com.carlosvega.literalura.models.BookList;
import com.carlosvega.literalura.service.ReadApi;

import java.util.Scanner;

public class Main {
    //variables and constants
    private final String URL_BASE = "https://gutendex.com/books/";
    ReadApi apireader = new ReadApi();
    JsonConverter jsonConverter = new JsonConverter();
    private int userOption;
    Scanner input = new Scanner(System.in);
    String initialMessage = "-------------------------\n" +
            "Elija una de las siguientes opciones: \n" +
            "1- Buscar libro por titulo\n" +
            "2- Mostrar libros registrados\n" +
            "3- Mostrar autores registrados\n" +
            "4- Mostrar autores vivos en un año determinado\n" +
            "5- Mostrar libros por idioma\n" +
            "0- Salir\n" +
            "Su eleccion: ";
    int userElection;
    public void showMenu(){
        var json = apireader.obtenerDatos(URL_BASE);
        var serializado = jsonConverter.obtenerDatos(json, BookList.class);
        System.out.println(serializado);

        //init program
        System.out.println(initialMessage);
        userElection = input.nextInt();
        input.nextLine();
        switch (userElection){
            case(1):
                method1();
        }
    }

    //option1
    public void method1(){

    }
    //option2
    //option3
    //option4
    //option5
    //option0
}
