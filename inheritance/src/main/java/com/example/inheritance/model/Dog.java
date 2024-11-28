package com.example.inheritance.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Dog extends Animal{

    String color;
    String breed;
    Integer age;
    Float weight;
    Integer height;

    public Dog() {
        super();
    }


    @Override
    public String makeNoise() {
        return "HamHam";
    }
}
