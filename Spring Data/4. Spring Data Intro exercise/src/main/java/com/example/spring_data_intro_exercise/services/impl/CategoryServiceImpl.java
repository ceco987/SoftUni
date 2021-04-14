package com.example.spring_data_intro_exercise.services.impl;

import com.example.spring_data_intro_exercise.constants.GlobalConstants;
import com.example.spring_data_intro_exercise.entities.Category;
import com.example.spring_data_intro_exercise.repositories.CategoryRepository;
import com.example.spring_data_intro_exercise.services.CategoryService;
import com.example.spring_data_intro_exercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static com.example.spring_data_intro_exercise.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() !=0){
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r->{
                    Category category = new Category(r);
                    this.categoryRepository.saveAndFlush(category);
                });
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }
}
