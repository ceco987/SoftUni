package com.example.spring_data_advanced_querying.repositories;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.entities.Shampoo;
import com.example.spring_data_advanced_querying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllByLabel_IdOrSizeOrderByPrice(Long id, Size size);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(double Price);

    @Query("SELECT s from Shampoo s " +
            "Join Ingredient i " +
            "where i in :ingredients")
    List<Shampoo> findAllByIngredientsIn(@Param("ingredients")Iterable<Ingredient> ingredients);
}
