package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.repositories.BookRepository;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BookServiceImpl implements BookService {
    private final FileUtil fileUtil;
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(FileUtil fileUtil, BookRepository bookRepository) {
        this.fileUtil = fileUtil;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooksToDB() throws IOException {
        String [] lines = this.fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);

    }
}
