package com.example.spring_data_advanced_querying.repositories;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.entities.Shampoo;
import com.example.spring_data_advanced_querying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllByLabel_IdOrSizeOrderByPrice(Long id, Size size);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(double minPrice);
    int countShampooByPriceIsLessThan(double maxPrice);

    @Query("SELECT s from Shampoo s " +
            "Join s.ingredients i " +
            "where i.name in :ingredients")
    List<Shampoo> findWithIngredientsIn(@Param("ingredients")Iterable<String> ingredients);

    @Query("SELECT s FROM Shampoo s " +
            "where s.ingredients.size < :maxCount")

    List<Shampoo> findWithIngredientsLessThan(@Param("maxCount") int maxCountOfIngredients);
}
