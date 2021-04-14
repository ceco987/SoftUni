package com.example.spring_data_advanced_querying.repositories;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
