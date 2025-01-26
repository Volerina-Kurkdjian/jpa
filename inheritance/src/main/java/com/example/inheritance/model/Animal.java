package com.example.inheritance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // use GenerationType.SEQUENCE for TABLE_PER_CLASS strategy
    private Long id;

    @Column(nullable=false)
    private String name;

    public abstract String makeNoise();

    public Animal() {
    }
}
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)