package com.example.spring_data_intro_exercise.services;

import com.example.spring_data_intro_exercise.entities.Author;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface AuthorService{
    void seedAuthors() throws IOException;
    int getAllAuthorsCount();
    Author findAuthorById(Long id);
    List<Author> findAllAuthorsByCountOfBooks();
    List<Author> findAuthorsWithBooksBefore1900();
}
