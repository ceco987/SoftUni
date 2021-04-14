package com.example.spring_data_intro_exercise.services;

import com.example.spring_data_intro_exercise.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> getAllBooksAfter2000();
    List<Book> getAllBooksByGeorgePowell();
}
