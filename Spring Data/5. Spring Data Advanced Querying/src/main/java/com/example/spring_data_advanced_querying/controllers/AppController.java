package com.example.spring_data_advanced_querying.controllers;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.repositories.IngredientRepository;
import com.example.spring_data_advanced_querying.repositories.LabelRepository;
import com.example.spring_data_advanced_querying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
//        // Ex. 1
//        System.out.println("\tEx1 - Select Shampoos by Size");
//        this.shampooRepository.findAllBySizeOrderById(Size.MEDIUM)
//                .forEach(Printer::printShampoos);
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 2
//        System.out.println("\tEx2 - Select Shampoos by Size or Label");
//        this.shampooRepository.findAllByLabel_IdOrSizeOrderByPrice(10L,Size.MEDIUM)
//                .forEach(Printer::printShampoos);
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 3
//        System.out.println("\tEx3 - Select Shampoos by Price");
//        this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(5)
//                .forEach(Printer::printShampoos);
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 4
//        System.out.println("\tEx4 - Select Ingredients by Name");
//        this.ingredientRepository.findAllByNameStartingWith("M")
//                .forEach(Printer::printIngredients);
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 5
//        System.out.println("\tEx5 - Select Ingredients by Names");
//        this.ingredientRepository.findAllByNameInOrderByPrice(Set.of("Lavender","Herbs","Apple"))
//                .forEach(Printer::printIngredients);
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 6
//        System.out.println("\tEx6 - Count Shampoos by Price");
//        System.out.println(this.shampooRepository.countShampooByPriceIsLessThan(8.5));
//
//        // Ex. 7
//        System.out.println("\tEx7 - Select Shampoos by Ingredients");
//        this.shampooRepository.findWithIngredientsIn(Set.of("Berry","Mineral-Collagen"))
//                .forEach(i-> System.out.println(i.getBrand()));
//
//        System.out.println("-".repeat(100));
//
//        // Ex. 8
//        System.out.println("\tEx8 - Select Shampoos by Ingredients Count");
//        this.shampooRepository.findWithIngredientsLessThan(2)
//                .forEach(i-> System.out.println(i.getBrand()));
//
//        System.out.println("-".repeat(100));

        /**
         *     Note:
         * Named Queries are intentionally not used for the next 3 tasks as they only prolong the solution.
         * Standard JPA queries are used instead, which can be found in the respective repositories
         */

        // Ex. 9
//        System.out.println("\tEx9 - Delete Ingredients by Name");
//        deleteIngredients("Apple");
//
//        System.out.println("-".repeat(100));

        // Ex. 10
//        System.out.println("Affected records: " + this.ingredientRepository.updateIngredientsPrice());
//        this.ingredientRepository.findAll().forEach(i -> {
//            System.out.printf("%s - %.2f\n",
//                    i.getName(), i.getPrice());
//        });

        // Ex. 11
        System.out.println("\tEx11 - Update Ingredients by Names");
        int affectedRows = this.ingredientRepository.updateIngredientsByNamesAndPercentage(0.1,Set.of("Berry", "Mineral-Collagen"));
        System.out.printf("Change completed.%nAffected rows: %d%n",affectedRows);
    }

    public void deleteIngredients(String ingredientName) {
        System.out.print("-".repeat(50) + "\n\n\n");
        System.out.println("*".repeat(50));
        System.out.println("BEFORE DELETE");
        System.out.println("*".repeat(50));
        this.shampooRepository.findAll().forEach(s -> System.out.println(s.getBrand() + "\n\t" + s.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")) + "\n"));
        System.out.print("\n\n\n" + "-".repeat(50) + "\n");

        Ingredient ingredientToDelete = this.ingredientRepository.findByName(ingredientName);
        this.shampooRepository.findWithIngredientsIn(Set.of(ingredientName))
                .forEach(s -> s.getIngredients().remove(ingredientToDelete));
        int deleted = this.ingredientRepository.deleteIngredient(ingredientName);
        System.out.println("*".repeat(50));
        System.out.println("AFTER DELETE");
        System.out.println("*".repeat(50));
        System.out.println("Deleted ingredients: " + deleted);
        this.shampooRepository.findAll().forEach(s -> System.out.println(s.getBrand() + "\n\t" + s.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")) + "\n"));
    }

}
