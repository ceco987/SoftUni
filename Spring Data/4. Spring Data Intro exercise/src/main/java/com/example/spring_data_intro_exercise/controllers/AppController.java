package com.example.spring_data_intro_exercise.controllers;

import com.example.spring_data_intro_exercise.entities.Book;
import com.example.spring_data_intro_exercise.services.AuthorService;
import com.example.spring_data_intro_exercise.services.BookService;
import com.example.spring_data_intro_exercise.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        // Ex.1
//        this.bookService.getAllBooksAfter2000().forEach(b->{
//            System.out.println(b.getTitle());
//        });

        // Ex. 2
//        this.authorService.findAuthorsWithBooksBefore1900()
//                .forEach(a->{
//                    System.out.printf("%s %s%n",
//                            a.getFirstName(),
//                            a.getLastName());
//                });

        // Ex. 3
//        this.authorService.findAllAuthorsByCountOfBooks()
//                .forEach(a->{
//                    System.out.printf("%s %s %d%n",
//                            a.getFirstName(),
//                            a.getLastName(),
//                            a.getBooks().size());
//                });

        // Ex. 4
//            this.bookService.getAllBooksByGeorgePowell().forEach(b->{
//                System.out.printf("%s. Released in %s.\n\t %d copies sold.\n",
//                        b.getTitle(),
//                        b.getReleaseDate(),
//                        b.getCopies());
//            });
    }
}
