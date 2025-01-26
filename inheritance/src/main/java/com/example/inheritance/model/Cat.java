package com.example.inheritance.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Cat extends Animal{

//    String name;
    String color;
    String breed;
    Integer age;
    Float weight;
    Integer height;

    public Cat() {
        super();
    }

    @Override
    public String makeNoise() {
        return "Miau";
    }
}
