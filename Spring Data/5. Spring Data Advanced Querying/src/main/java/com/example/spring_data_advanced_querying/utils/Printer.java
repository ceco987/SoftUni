package com.example.spring_data_advanced_querying.utils;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.entities.Shampoo;

public class Printer {
    public static void printShampoos(Shampoo s){
        System.out.printf("%s %s %.2f%n",
               s.getBrand(), s.getSize(),s.getPrice());
    }

    public static void printIngredients(Ingredient i){
        System.out.println(i.getName());
    }
}
