package com.example.spring_data_advanced_querying.controllers;

import com.example.spring_data_advanced_querying.entities.Size;
import com.example.spring_data_advanced_querying.repositories.IngredientRepository;
import com.example.spring_data_advanced_querying.repositories.LabelRepository;
import com.example.spring_data_advanced_querying.repositories.ShampooRepository;
import com.example.spring_data_advanced_querying.utils.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {
    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public AppController(ShampooRepository shampooRepository, LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Ex. 1
        System.out.println("\tEx1 - Select Shampoos By Size");
        this.shampooRepository.findAllBySizeOrderById(Size.MEDIUM).forEach(Printer::print);

        System.out.println("-".repeat(100));

        // Ex. 2
        System.out.println("\tEx2 - Select Shampoos By Size or Label");
        this.shampooRepository.findAllByLabel_IdOrSizeOrderByPrice(10L,Size.MEDIUM).forEach(Printer::print);

        System.out.println("-".repeat(100));

        // Ex. 3
        System.out.println("\tEx3 - Select Shampoos By Price");
        this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(5).forEach(Printer::print);

    }

}
