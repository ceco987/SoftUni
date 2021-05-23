package com.softuni.springintroex.components;

import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationComponent implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public ApplicationComponent(CategoryService categoryService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        this.categoryService.seedCategoriesInDB();
        this.authorService.seedAuthorsInDB();
    }

}
