package com.example.spring_data_advanced_querying.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ingredients")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private double price=0;

    @ToString.Exclude
    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos = new HashSet<>();
}
