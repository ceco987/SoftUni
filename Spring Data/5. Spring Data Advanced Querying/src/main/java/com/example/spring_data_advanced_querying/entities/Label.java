package com.example.spring_data_advanced_querying.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "labels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private String subtitle;

    @ToString.Exclude
    @OneToMany(mappedBy = "label")
    private Set<Shampoo> shampoos;

}
