package com.example.spring_data_intro_exercise.services.impl;

import com.example.spring_data_intro_exercise.constants.GlobalConstants;
import com.example.spring_data_intro_exercise.entities.Author;
import com.example.spring_data_intro_exercise.repositories.AuthorRepository;
import com.example.spring_data_intro_exercise.services.AuthorService;
import com.example.spring_data_intro_exercise.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.spring_data_intro_exercise.constants.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(this.authorRepository.count()!=0){
            return;
        }
        String[] fileContent = this.fileUtil
                .readFileContent(AUTHORS_FILE_PATH);
        Arrays.stream(fileContent)
                .forEach(c->{
                    String[] params = c.split("\\s+");
                    Author author = new Author(params[0],params[1]);
                    this.authorRepository.saveAndFlush(author);
                });

    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository
                .getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> findAuthorsWithBooksBefore1900() {
        return this.authorRepository.findAllByBooksReleaseDate();
    }
}
