package com.example.spring_data_intro_exercise.services;

import com.example.spring_data_intro_exercise.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
    Category getCategoryById(Long id);
}
