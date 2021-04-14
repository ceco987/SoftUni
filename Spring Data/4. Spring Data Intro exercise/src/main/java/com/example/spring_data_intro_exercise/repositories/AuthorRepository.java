package com.example.spring_data_intro_exercise.repositories;

import com.example.spring_data_intro_exercise.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a order by a.books.size DESC")
    List<Author> findAuthorByCountOfBook();
    @Query("SELECT a FROM Author a JOIN Book b on b.author.id = a.id " +
            "WHERE b.releaseDate < '1990/01/01'")
    List<Author> findAllByBooksReleaseDate();
}
