package com.carlosvega.literalura.main;

import com.carlosvega.literalura.converter.JsonConverter;
import com.carlosvega.literalura.models.Author;
import com.carlosvega.literalura.models.BookData;
import com.carlosvega.literalura.models.BookList;
import com.carlosvega.literalura.repository.IBookRepository;
import com.carlosvega.literalura.service.ReadApi;

import com.carlosvega.literalura.models.Book;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    //variables and constants
    private final String URL_BASE = "https://gutendex.com/books/";
    ReadApi apireader = new ReadApi();
    JsonConverter jsonConverter = new JsonConverter();
    private int userOption;
    Scanner input = new Scanner(System.in);
    private String initialMessage = "-------------------------\n" +
            "Elija una de las siguientes opciones: \n" +
            "1- Buscar libro por titulo\n" +
            "2- Mostrar libros registrados\n" +
            "3- Mostrar autores registrados\n" +
            "4- Mostrar autores vivos en un año determinado\n" +
            "5- Mostrar libros por idioma\n" +
            "0- Salir\n" +
            "Su eleccion: ";
    private String requestTitleMessage = "Escriba el nomobre del libro que desea buscar:";
    List<Book> bookList;
    List<Author> authorList;
    private IBookRepository bookRepository;

    //contructor with dependency
    public Main(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showMenu(){
        var json = apireader.obtenerDatos(URL_BASE);
        var serializado = jsonConverter.obtenerDatos(json, BookList.class);
        //System.out.println(serializado);

        //map books class
        var booksListData = serializado.bookData();
        bookList = booksListData.stream()
                .map(b -> new Book(b))
                .collect(Collectors.toList());
        //bookList.forEach(System.out::println);

        //init program
        System.out.println(initialMessage);
        userOption = input.nextInt();
        input.nextLine();
        switch (userOption){
            case(1):
                searchBook();
        }

    }
    //option1
    public void searchBook(){
        System.out.println(requestTitleMessage);
        String inputTitle = input.nextLine();
        var json = apireader.obtenerDatos(URL_BASE + "?search=" + inputTitle.replace(" ","+"));
        var serializado = jsonConverter.obtenerDatos(json, BookList.class);
        //find book but datatype Bookdata
        Optional<BookData> wantedBook = serializado.bookData().stream()
                .filter(l -> l.title().toUpperCase().contains(inputTitle.toUpperCase()))
                .findFirst();
        if(wantedBook.isPresent()){
            System.out.println("libro encontrado: " + wantedBook.get());
            //pass data to book object
            Book book = new Book(wantedBook.get());
            //map authors from object book
            authorList = wantedBook.get()
                    .authorDataList().stream()
                    .map(a->new Author(a))
                    .collect(Collectors.toList());
            book.setAuthorList(authorList);

            bookRepository.save(book);
        }else {
            System.out.println("No se encontro el libro");
        }

    }

    //option2
    //option3
    //option4
    //option5
    //option0

}
