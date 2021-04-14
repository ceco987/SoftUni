package com.example.spring_data_advanced_querying.utils;

import com.example.spring_data_advanced_querying.entities.Shampoo;

public class Printer {
    public static void print(Shampoo s){
        System.out.printf("%s %s %.2f%n",
               s.getBrand(), s.getSize(),s.getPrice());
    }
}
