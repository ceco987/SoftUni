package com.example.spring_data_advanced_querying.repositories;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String startingLetter);

    List<Ingredient> findAllByNameInOrderByPrice(Iterable<String> ingredientNames);

    Ingredient findByName(String name);

    @Query("DELETE from Ingredient i " +
            "WHERE i.name = :ingredientName")
    @Transactional
    @Modifying
    int deleteIngredient(@Param("ingredientName") String name);


    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price*1.10")
    int updateIngredientsPrice();

    /**
     * Updates all Ingredients with the specified name with the provided percentage
     *
     * @param percentage desired percentage of change in Decimal format (e.g. 0.1 = 10%)
     * @param names      Any Iterable collection of names
     * @return The number of affected rows
     */
    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * (1.0 + :percentage) " +
            "WHERE i.name in :names")
    int updateIngredientsByNamesAndPercentage(@Param("percentage") double percentage,
                                              @Param("names") Iterable<String> names);
}
