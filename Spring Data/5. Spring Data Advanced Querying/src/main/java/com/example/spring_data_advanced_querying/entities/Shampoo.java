package com.example.spring_data_advanced_querying.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "shampoos")
public class Shampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String brand;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @ManyToOne()
    @JoinColumn(name = "label",referencedColumnName = "id")
    private Label label;
    @ManyToMany (fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName = "id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
}
