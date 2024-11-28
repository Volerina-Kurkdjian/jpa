package com.example.inheritance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@Getter
@Setter
@AllArgsConstructor
public abstract class Animal {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // use GenerationType.SEQUENCE for TABLE_PER_CLASS strategy
    private Long id;

    @Column(nullable=false)
    private String name;

    public abstract String makeNoise();

    public Animal() {
    }
}
